package pl.dominisz.creditcardapplication.service;

import org.springframework.stereotype.Service;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.exception.CreditCardEntityNotFoundException;
import pl.dominisz.creditcardapplication.model.CreditCardForm;
import pl.dominisz.creditcardapplication.repository.CreditCardEntityRepository;

import java.util.List;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
@Service
public class CreditCardEntityServiceImpl implements CreditCardEntityService {

    private final CreditCardEntityRepository creditCardEntityRepository;
    private final CreditCardGenerator creditCardGenerator;

    public CreditCardEntityServiceImpl(CreditCardEntityRepository creditCardEntityRepository, CreditCardGenerator creditCardGenerator) {
        this.creditCardEntityRepository = creditCardEntityRepository;
        this.creditCardGenerator = creditCardGenerator;
    }

    @Override
    public List<CreditCardEntity> findAll() {
        return creditCardEntityRepository.findAll();
    }

    @Override
    public CreditCardEntity findByNumber(String number) {
        return creditCardEntityRepository.findByNumber(number)
                .orElseThrow(CreditCardEntityNotFoundException::new);
    }

    @Override
    public void create(CreditCardForm creditCardForm) {
        CreditCardEntity creditCardEntity = new CreditCardEntity();

        creditCardEntity.setFirstName(creditCardForm.getFirstName());
        creditCardEntity.setLastName(creditCardForm.getLastName());
        creditCardEntity.setAmount(creditCardForm.getAmount());

        creditCardEntity.setNumber(creditCardGenerator.generateNumber());
        creditCardEntity.setCcv(creditCardGenerator.generateCCV());
        creditCardEntity.setExpiryDate(creditCardGenerator.generateExpiryDate());

        creditCardEntityRepository.save(creditCardEntity);
    }

}
