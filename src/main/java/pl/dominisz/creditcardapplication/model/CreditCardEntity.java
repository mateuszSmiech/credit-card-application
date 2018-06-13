package pl.dominisz.creditcardapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
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
