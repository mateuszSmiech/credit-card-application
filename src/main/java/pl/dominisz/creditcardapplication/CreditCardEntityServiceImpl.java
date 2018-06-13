package pl.dominisz.creditcardapplication;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
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

}
