package pl.dominisz.creditcardapplication;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * http://dominisz.pl
 * 12.06.2018
 */
@Service
public class ChargeServiceImpl implements ChargeService {

    @Override
    public ChargeResult charge(ChargeRequest chargeRequest) {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setChargeDateTime(LocalDateTime.now());
        chargeResult.setSuccessful(true);
        chargeResult.setDeclineMessage("");
        return chargeResult;
    }

}
