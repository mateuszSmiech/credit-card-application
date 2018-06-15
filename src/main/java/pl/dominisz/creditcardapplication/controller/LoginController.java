package pl.dominisz.creditcardapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * http://dominisz.pl
 * 14.06.2018
 */
@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String loadLoginPage() {
        return "login";
    }

    @GetMapping(path = {"", "/"})
    public String loadMainPage() {
        return "hello";
    }
}
