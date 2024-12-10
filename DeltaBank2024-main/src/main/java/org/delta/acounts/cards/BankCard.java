package org.delta.acounts.cards;

import org.delta.acounts.BankAccount;

import java.io.Serializable;

public class BankCard implements Serializable {
    private static final long serialVersionUID = 1L;
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