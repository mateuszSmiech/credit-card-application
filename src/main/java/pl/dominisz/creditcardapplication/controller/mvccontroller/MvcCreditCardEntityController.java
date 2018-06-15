package pl.dominisz.creditcardapplication.controller.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.creditcardapplication.form.CreditCardForm;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;
import pl.dominisz.creditcardapplication.service.CreditCardEntityService;
import pl.dominisz.creditcardapplication.utils.CreditCardUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/mvc/creditCards")
public class MvcCreditCardEntityController {

    private final CreditCardEntityService creditCardEntityService;
    private final CreditCardUtils creditCardUtils;

    public MvcCreditCardEntityController(CreditCardEntityService creditCardEntityService, CreditCardUtils creditCardUtils) {
        this.creditCardEntityService = creditCardEntityService;
        this.creditCardUtils = creditCardUtils;
    }

    @RequestMapping(value = {"/", "/cardlist"}, method = RequestMethod.GET)
    public String personList(Model model) {
        List<CreditCardEntity> creditCardEntityServiceList = creditCardEntityService.findAll();
        model.addAttribute("creditCard", creditCardEntityServiceList);

        return "showAllCards";
    }

    @RequestMapping(value = {"/showDetail/{id}"}, method = RequestMethod.GET)
    public String cardDetails(@PathVariable Long id, Model model) {
        CreditCardEntity creditCard = creditCardEntityService.findById(id);
        model.addAttribute("creditCard", creditCard);
        return "creditCard";
    }

    @GetMapping(value = {"/addCard"})
    public String addCard(Model model) {
        CreditCardForm creditCardForm = new CreditCardForm();
        model.addAttribute("creditCardForm", creditCardForm);
        return "addCardForm";
    }

    @RequestMapping(value = {"/add"})
    public String add(@ModelAttribute CreditCardForm creditCardForm) {
                CreditCardEntity cardEntity = new CreditCardEntity();
        String cardNumber = creditCardUtils.generateCardNumber();
        int ccv = creditCardUtils.generateCCV();
        LocalDate expDate = creditCardUtils.generateExpDate();
        cardEntity.setCcv(ccv);
        cardEntity.setNumber(cardNumber);
        cardEntity.setExpiryDate(expDate);
        cardEntity.setFirstName(creditCardForm.getFirstName());
        cardEntity.setLastName(creditCardForm.getLastName());
        cardEntity.setAmount(creditCardForm.getAmount());
        creditCardEntityService.addCreditCard(cardEntity);

        return "redirect:cardlist";
    }




}
