package org.delta.acounts.cards;

import org.delta.acounts.BankAccount;

public class BankCard {
    private String number;
    private String pin;

    private BankAccount owner;

    public BankCard(String number, String pin, BankAccount owner) {
        this.number = number;
        this.pin = pin;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BankAccount getOwner()
    {
        return owner;
    }

}