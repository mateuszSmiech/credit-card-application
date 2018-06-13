package pl.dominisz.creditcardapplication;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * http://dominisz.pl
 * 11.06.2018
 */
@Data
@NoArgsConstructor
public class ChargeResult {

    private static final String INVALID_DATA = "Invalid credit card data";
    private static final String INVALID_AMOUNT = "Amount exceeds card limit";
    private static final String EMPTY = "";

    private LocalDateTime chargeDateTime;
    private boolean successful;
    private String declineMessage;

    public static ChargeResult forNonExistingCard() {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setSuccessful(false);
        chargeResult.setDeclineMessage(INVALID_DATA);
        return chargeResult;
    }

    public static ChargeResult forSuccessfulCharge() {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setChargeDateTime(LocalDateTime.now());
        chargeResult.setSuccessful(true);
        chargeResult.setDeclineMessage(EMPTY);
        return chargeResult;
    }

    public static ChargeResult forTooLargeAmount() {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setSuccessful(false);
        chargeResult.setDeclineMessage(INVALID_AMOUNT);
        return chargeResult;
    }
}
