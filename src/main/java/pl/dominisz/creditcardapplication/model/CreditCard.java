package pl.dominisz.creditcardapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * http://dominisz.pl
 * 11.06.2018
 */
@Data
@NoArgsConstructor
public class CreditCard {

    private String number;
    private String owner;
    private String expiryDate;
    private int ccv;

}
