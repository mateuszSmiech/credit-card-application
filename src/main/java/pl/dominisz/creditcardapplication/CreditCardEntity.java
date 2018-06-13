package pl.dominisz.creditcardapplication;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreditCardEntity {

    @Id
    private Long id;

    private String number;
    private String firstName;
    private String lastName;
    private LocalDate expiryDate;
    private int ccv;
    private BigDecimal amount;

}
