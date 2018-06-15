package pl.dominisz.creditcardapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/")
    public String loadIndexPage() {
        return "redirect:/mvc/creditCards/cardlist";
    }
}
