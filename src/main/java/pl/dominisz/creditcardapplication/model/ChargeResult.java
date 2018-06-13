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

    private static ChargeResult invalidAuth(String message) {
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
        return invalidAuth(INVALID_DATA);
    }

    public static ChargeResult forTooLargeAmount() {
        return invalidAuth(INVALID_AMOUNT);
    }

    public static ChargeResult invalidCCV() {
        return invalidAuth(INVALID_CCV);
    }

    public static ChargeResult forInvalidOwnerData(){
        return invalidAuth(INVALID_OWNER);
    }

    public static ChargeResult forExpiredDate() {
        return invalidAuth(INVALID_EXPIRY_DATE);
    }

    public static ChargeResult forMinusAmount() {
        return invalidAuth(WRONG_AMOUNT);
    }
}
