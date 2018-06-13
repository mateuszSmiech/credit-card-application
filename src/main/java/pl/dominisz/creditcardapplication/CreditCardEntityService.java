package pl.dominisz.creditcardapplication;

import java.util.List;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
public interface CreditCardEntityService {

    List<CreditCardEntity> findAll();

    CreditCardEntity findByNumber(String number);
}
