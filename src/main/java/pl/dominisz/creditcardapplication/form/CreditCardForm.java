package pl.dominisz.creditcardapplication.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCardForm {

    private String firstName;
    private String lastName;
    private BigDecimal amount;
}
