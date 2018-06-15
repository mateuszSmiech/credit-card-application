package pl.dominisz.creditcardapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 14.06.2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardForm {

    private String firstName;
    private String lastName;
    private BigDecimal amount;

}
