package pl.dominisz.creditcardapplication.mvccontroller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.model.CreditCardForm;
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

    @GetMapping(path = {"/", "/all"})
    public String findAll(Model model) {
        model.addAttribute("creditCards", creditCardEntityService.findAll());
        return "creditCardList";
    }

    @GetMapping(path = "/{number}")
    public String findCardByNumber(@PathVariable String number, Model model) {
        model.addAttribute("creditCard", creditCardEntityService.findByNumber(number));
        return "creditCard";
    }

    @GetMapping(path = "/addCard")
    public String addCardForm(Model model) {
        model.addAttribute("creditCardForm", new CreditCardForm());
        return "addCard";
    }

    @PostMapping(path = "/addCard")
    public String createCard(@ModelAttribute("creditCardForm") CreditCardForm creditCardForm,
                             Model model) {
        creditCardEntityService.create(creditCardForm);
        return "redirect:/mvc/creditCards/all";
    }
}
