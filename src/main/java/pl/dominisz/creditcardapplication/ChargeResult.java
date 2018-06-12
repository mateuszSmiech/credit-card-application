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

    private LocalDateTime chargeDateTime;
    private boolean successful;
    private String declineMessage;

}
