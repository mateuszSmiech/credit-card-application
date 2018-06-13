package pl.dominisz.creditcardapplication;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        Optional<CreditCardEntity> optionalCreditCardEntity = creditCardEntityRepository.findByNumber(requestedCreditCard.getNumber());

        if (!optionalCreditCardEntity.isPresent()) {
            return ChargeResult.forNonExistingCard();
        }

        CreditCardEntity creditCardEntity = optionalCreditCardEntity.get();

        if (chargeRequest.getAmount().compareTo(creditCardEntity.getAmount()) > 0) {
            return ChargeResult.forTooLargeAmount();
        }

        creditCardEntity.setAmount(creditCardEntity.getAmount().subtract(chargeRequest.getAmount()));
        creditCardEntityRepository.save(creditCardEntity);

        return ChargeResult.forSuccessfulCharge();
    }

}
