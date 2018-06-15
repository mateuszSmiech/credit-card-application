package pl.dominisz.creditcardapplication.controller.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dominisz.creditcardapplication.model.ChargeRequest;
import pl.dominisz.creditcardapplication.model.ChargeResult;
import pl.dominisz.creditcardapplication.service.ChargeService;

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
