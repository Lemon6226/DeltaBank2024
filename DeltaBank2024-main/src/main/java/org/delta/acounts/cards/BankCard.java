package org.delta.acounts.cards;

public class BankCard {
    private String number;
    private String pin;

    public BankCard(String number, String pin) {
        this.number = number;
        this.pin = pin;
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
}