package pl.dominisz.creditcardapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CreditCardUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

}
