package org.delta.acounts.cards;

public class BankCardFactory {
    public BankCard createBankCard(String number, String pin) {
        return new BankCard(number, pin);
    }
}