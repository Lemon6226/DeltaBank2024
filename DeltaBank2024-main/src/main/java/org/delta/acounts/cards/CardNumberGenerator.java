package org.delta.acounts.cards;

import java.util.Random;

public class CardNumberGenerator {
    private static final int CARD_NUMBER_LENGTH = 16;

    public String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CARD_NUMBER_LENGTH; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }
}
