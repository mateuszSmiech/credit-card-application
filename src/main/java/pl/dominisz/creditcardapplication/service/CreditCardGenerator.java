package pl.dominisz.creditcardapplication.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

/**
 * http://dominisz.pl
 * 14.06.2018
 */
@Component
public class CreditCardGenerator {

    private static final int CREDIT_CARD_NUMBER_LENGTH = 9;
    private static final long EXPIRY_YEARS = 2;

    private Random random = new Random();

    public String generateNumber() {
        return RandomStringUtils.random(CREDIT_CARD_NUMBER_LENGTH, false, true);
    }

    public int generateCCV() {
        return 100 + random.nextInt(900);
    }

    public LocalDate generateExpiryDate() {
        return LocalDate.now().plusYears(EXPIRY_YEARS);
    }

}
