package pl.dominisz.creditcardapplication.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class CreditCardUtils {
    private Random rand = new Random();
    private int creditCardLength = 9;
    private int expPeriod = 2;

    public String generateCardNumber() {
        String creditCardNumber = "";;
        rand = new Random();
        for(int i = 0;i<creditCardLength-1;i++) {
            int number = rand.nextInt(9);
            creditCardNumber += number;
        }
        return creditCardNumber;
    }

    public int generateCCV() {
        int ccv = rand.nextInt(999 - 100 + 1)+100;
        return ccv;
    }

    public LocalDate generateExpDate() {
        LocalDate date = LocalDate.now();
        return date.plusYears(expPeriod);
    }


}
