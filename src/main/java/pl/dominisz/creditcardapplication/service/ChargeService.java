package pl.dominisz.creditcardapplication.service;

import pl.dominisz.creditcardapplication.model.ChargeRequest;
import pl.dominisz.creditcardapplication.model.ChargeResult;

/**
 * http://dominisz.pl
 * 12.06.2018
 */
public interface ChargeService {

    ChargeResult charge(ChargeRequest chargeRequest);

}
