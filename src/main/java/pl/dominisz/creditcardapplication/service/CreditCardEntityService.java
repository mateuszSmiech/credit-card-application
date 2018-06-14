package pl.dominisz.creditcardapplication.service;

import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.model.CreditCardForm;

import java.util.List;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
public interface CreditCardEntityService {

    List<CreditCardEntity> findAll();

    CreditCardEntity findByNumber(String number);

    void create(CreditCardForm creditCardForm);
}
