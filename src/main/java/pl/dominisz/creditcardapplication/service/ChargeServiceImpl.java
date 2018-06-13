package pl.dominisz.creditcardapplication.service;

import org.springframework.stereotype.Service;
import pl.dominisz.creditcardapplication.model.ChargeRequest;
import pl.dominisz.creditcardapplication.model.ChargeResult;
import pl.dominisz.creditcardapplication.model.CreditCard;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.repository.CreditCardEntityRepository;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * http://dominisz.pl
 * 12.06.2018
 */
@Service
public class ChargeServiceImpl implements ChargeService {

    private CreditCardEntityRepository creditCardEntityRepository;

    public ChargeServiceImpl(CreditCardEntityRepository creditCardEntityRepository) {
        this.creditCardEntityRepository = creditCardEntityRepository;
    }

    @Override
    public ChargeResult charge(ChargeRequest chargeRequest) {
        CreditCard requestedCreditCard = chargeRequest.getCreditCard();

        Optional<CreditCardEntity> optionalCreditCardEntity = creditCardEntityRepository
                .findByNumber(requestedCreditCard.getNumber());

        if (!optionalCreditCardEntity.isPresent()) {
            return ChargeResult.forNonExistingCard();
        }

        CreditCardEntity creditCardEntity = optionalCreditCardEntity.get();

        if (chargeRequest.getAmount().compareTo(creditCardEntity.getAmount()) > 0) {
            return ChargeResult.forTooLargeAmount();
        }

        if (requestedCreditCard.getCcv() != creditCardEntity.getCcv()) {
            return ChargeResult.forFailedCharge();
        }

        if (!requestedCreditCard.getOwner().equalsIgnoreCase(
                creditCardEntity.getFirstName() + " " + creditCardEntity.getLastName())) {
            return ChargeResult.forFailedCharge();
        }

        if (chargeRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return ChargeResult.forFailedCharge();
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String expiryDate = creditCardEntity.getExpiryDate().format(dateTimeFormatter);
        if (!requestedCreditCard.getExpiryDate().equals(expiryDate)) {
            return ChargeResult.forFailedCharge();
        }

        creditCardEntity.setAmount(creditCardEntity.getAmount().subtract(chargeRequest.getAmount()));
        creditCardEntityRepository.save(creditCardEntity);

        return ChargeResult.forSuccessfulCharge();
    }

}
