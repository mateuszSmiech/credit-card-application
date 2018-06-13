package pl.dominisz.creditcardapplication.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dominisz.creditcardapplication.service.CreditCardEntityService;

/**
 * http://dominisz.pl
 * 13.06.2018
 */
@Controller
@RequestMapping("/mvc/creditCards")
public class MvcCreditCardEntityController {

    private final CreditCardEntityService creditCardEntityService;

    public MvcCreditCardEntityController(CreditCardEntityService creditCardEntityService) {
        this.creditCardEntityService = creditCardEntityService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("creditCards", creditCardEntityService.findAll());
        return "creditCardList";
    }

}
