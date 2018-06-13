package pl.dominisz.creditcardapplication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dominisz.creditcardapplication.model.ChargeRequest;
import pl.dominisz.creditcardapplication.model.ChargeResult;
import pl.dominisz.creditcardapplication.service.ChargeService;

/**
 * http://dominisz.pl
 * 11.06.2018
 */
@RestController
public class ChargeController {

    private final ChargeService chargeService;

    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @PostMapping("/chargeRequests")
    public ChargeResult charge(@RequestBody ChargeRequest chargeRequest) {
        return chargeService.charge(chargeRequest);
    }

}
