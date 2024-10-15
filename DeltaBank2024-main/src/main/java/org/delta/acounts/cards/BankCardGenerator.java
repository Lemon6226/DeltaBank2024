package org.delta.acounts.cards;

import com.google.inject.Inject;

public class BankCardGenerator {
    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardFactory bankCardFactory;

    public BankCard createBankCard(String pin) {
        String cardNumber = cardNumberGenerator.generateCardNumber();
        return bankCardFactory.createBankCard(cardNumber, pin);
    }
}
