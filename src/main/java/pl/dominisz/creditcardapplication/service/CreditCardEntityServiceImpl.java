package pl.dominisz.creditcardapplication.service;

import org.springframework.stereotype.Service;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.exception.CreditCardEntityNotFoundException;
import pl.dominisz.creditcardapplication.repository.CreditCardEntityRepository;
import pl.dominisz.creditcardapplication.utils.CreditCardUtils;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditCardEntityServiceImpl implements CreditCardEntityService {

    private final CreditCardEntityRepository creditCardEntityRepository;

    public CreditCardEntityServiceImpl(CreditCardEntityRepository creditCardEntityRepository) {
        this.creditCardEntityRepository = creditCardEntityRepository;
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
    public CreditCardEntity findById(Long id) {
        return creditCardEntityRepository.findById(id)
                .orElseThrow(CreditCardEntityNotFoundException::new);
    }

    @Override
    public void addCreditCard(CreditCardEntity creditCard) {
        creditCardEntityRepository.save(creditCard);
    }


}
