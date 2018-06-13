package pl.dominisz.creditcardapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
@RestController
@RequestMapping("/creditCards")
public class CreditCardEntityController {

    private final CreditCardEntityService creditCardEntityService;

    public CreditCardEntityController(CreditCardEntityService creditCardEntityService) {
        this.creditCardEntityService = creditCardEntityService;
    }

    @GetMapping
    public List<CreditCardEntity> findAll() {
        return creditCardEntityService.findAll();
    }

    @GetMapping(path = "/{number}")
    public CreditCardEntity findByNumber(@PathVariable String number) {
        return creditCardEntityService.findByNumber(number);
    }

}
