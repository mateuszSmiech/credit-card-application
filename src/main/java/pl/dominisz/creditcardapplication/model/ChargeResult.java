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
    private static final String INVALID_AMOUNT = "Amount exceeds card limit";
    private static final String EMPTY = "";
    private static final String INVALID_CCV = "Invalid CCV";
    private static final String INVALID_OWNER = "Invalid Name or Last Name.";
    private static final String INVALID_EXPIRY_DATE = "Invalid Expiry Date" ;
    private static final String WRONG_AMOUNT = "Amount cannot be minus.";


    private LocalDateTime chargeDateTime;
    private boolean successful;
    private String declineMessage;

    public static ChargeResult invalidAuth(String message) {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setSuccessful(false);
        chargeResult.setDeclineMessage(message);
        return chargeResult;
    }

    public static ChargeResult forSuccessfulCharge() {
        ChargeResult chargeResult = new ChargeResult();
        chargeResult.setChargeDateTime(LocalDateTime.now());
        chargeResult.setSuccessful(true);
        chargeResult.setDeclineMessage(EMPTY);
        return chargeResult;
    }

    public static ChargeResult forNonExistingCard() {
        ChargeResult chargeResult = invalidAuth(INVALID_DATA);
        return chargeResult;
    }

    public static ChargeResult forTooLargeAmount() {
        ChargeResult chargeResult = invalidAuth(INVALID_AMOUNT);
        return chargeResult;
    }

    public static ChargeResult invalidCCV() {
        ChargeResult chargeResult = invalidAuth(INVALID_CCV);
        return chargeResult;
    }

    public static ChargeResult forInvalidOwnerData(){
        ChargeResult chargeResult = invalidAuth(INVALID_OWNER);
        return chargeResult;
    }

    public static ChargeResult forExpiredDate() {
        ChargeResult chargeResult = invalidAuth(INVALID_EXPIRY_DATE);
        return chargeResult;
    }

    public static ChargeResult forMinusAmount() {
        ChargeResult chargeResult = invalidAuth(WRONG_AMOUNT);
        return chargeResult;
    }
}
