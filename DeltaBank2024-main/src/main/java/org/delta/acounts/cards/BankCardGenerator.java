package org.delta.acounts.cards;

import com.google.inject.Inject;
import org.delta.acounts.BankAccount;

public class BankCardGenerator {
    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardFactory bankCardFactory;

    public BankCard createBankCard(BankAccount bankAccount, String pin) {
        String cardNumber = cardNumberGenerator.generateCardNumber();
        return bankCardFactory.createBankCard(bankAccount, cardNumber, pin);
    }
}
