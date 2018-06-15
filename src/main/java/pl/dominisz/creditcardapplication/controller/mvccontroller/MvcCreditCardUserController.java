package pl.dominisz.creditcardapplication.controller.mvccontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dominisz.creditcardapplication.form.CreditCardUserForm;
import pl.dominisz.creditcardapplication.model.CreditCardUser;
import pl.dominisz.creditcardapplication.service.CreditCardUserService;

@Controller
@RequestMapping("/mvc/user")
public class MvcCreditCardUserController {

    private final CreditCardUserService creditCardUserService;

    public MvcCreditCardUserController(CreditCardUserService creditCardUserService) {
        this.creditCardUserService = creditCardUserService;
    }

    @GetMapping(path = "/")
    public String userForm(Model model) {
        CreditCardUserForm creditCardUserForm = new CreditCardUserForm();
        model.addAttribute("creditCardUserForm", creditCardUserForm);
        return "createUser";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute CreditCardUserForm creditCardUserForm) {

        CreditCardUser creditCardUser = new CreditCardUser();
        creditCardUser.setUsername(creditCardUserForm.getUsername());
        creditCardUser.setPassword(creditCardUserForm.getPassword());
        creditCardUser.setEmail(creditCardUserForm.getEmail());
        creditCardUserService.createUser(creditCardUser);
        return "redirect:/login";
    }

}
