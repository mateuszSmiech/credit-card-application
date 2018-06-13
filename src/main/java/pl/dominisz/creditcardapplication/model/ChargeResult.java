package pl.dominisz.creditcardapplication.model;

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
    private static final String AMOUNT_LIMIT = "Amount exceeds card limit";
    private static final String INVALID_AMOUNT = "Invalid amount";
    private static final String EMPTY = "";

    private LocalDateTime chargeDateTime;
    private boolean successful;
    private String declineMessage;

    public static ChargeResult forSuccessfulCharge() {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setChargeDateTime(LocalDateTime.now());
        chargeResult.setSuccessful(true);
        chargeResult.setDeclineMessage(EMPTY);
        return chargeResult;
    }

    private static ChargeResult failedWithMessage(String message) {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setSuccessful(false);
        chargeResult.setDeclineMessage(message);
        return chargeResult;
    }

    public static ChargeResult forTooLargeAmount() {
        return failedWithMessage(AMOUNT_LIMIT);
    }

    public static ChargeResult forFailedCharge() {
        return failedWithMessage(INVALID_DATA);
    }

    public static ChargeResult forInvalidAmount() {
        return failedWithMessage(INVALID_AMOUNT);
    }
}
