package org.delta.acounts.cards;

import org.delta.acounts.BankAccount;

public class BankCardFactory {
    public BankCard createBankCard(BankAccount bankAccount, String number, String pin) {
        return new BankCard(number, pin, bankAccount);
    }
}