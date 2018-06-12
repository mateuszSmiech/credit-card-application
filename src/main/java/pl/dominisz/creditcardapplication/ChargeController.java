package pl.dominisz.creditcardapplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
