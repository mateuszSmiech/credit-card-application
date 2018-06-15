package pl.dominisz.creditcardapplication.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCardUserForm {

    private String username;
    private String password;
    private String email;
}
