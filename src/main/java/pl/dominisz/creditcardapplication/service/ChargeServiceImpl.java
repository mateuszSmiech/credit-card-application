package pl.dominisz.creditcardapplication.service;

import org.springframework.stereotype.Service;
import pl.dominisz.creditcardapplication.model.ChargeRequest;
import pl.dominisz.creditcardapplication.model.ChargeResult;
import pl.dominisz.creditcardapplication.model.CreditCard;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.repository.CreditCardEntityRepository;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

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
        //ccv check
        if (requestedCreditCard.getCcv() != creditCardEntity.getCcv()) {
            return ChargeResult.invalidCCV();
        }

        if (!requestedCreditCard.getOwner().equalsIgnoreCase(creditCardEntity.getFirstName() + " " + creditCardEntity.getLastName())){
            return ChargeResult.forInvalidOwnerData();
        }

        if(chargeRequest.getAmount().compareTo(BigDecimal.ZERO)<=0){
            return ChargeResult.forMinusAmount();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if(!requestedCreditCard.getExpiryDate().equals(creditCardEntity.getExpiryDate().format(formatter))) {
            return ChargeResult.forExpiredDate();
        }

        creditCardEntity.setAmount(creditCardEntity.getAmount().subtract(chargeRequest.getAmount()));
        creditCardEntityRepository.save(creditCardEntity);

        return ChargeResult.forSuccessfulCharge();
    }

}
