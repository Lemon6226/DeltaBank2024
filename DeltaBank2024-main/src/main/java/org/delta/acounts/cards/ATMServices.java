package org.delta.acounts.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.BankAccount;
import org.delta.acounts.MoneyTransferService;
import java.lang.Iterable;

import java.util.HashMap;
import java.util.Map;

public class ATMServices {
    @Inject
    BankAccount bankAccount;

    @Inject
    MoneyTransferService moneyTransferService;


    public void withdrawMoney(BankAccount account, String cardNumber, String pin, double amount) {
        BankCard card = account.getCard(cardNumber);
        if (card == null) {
            System.out.println("nenalezena karta");
            return;
        }

        if (!card.getPin().equals(pin)) {
            System.out.println("invalid PIN");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("nedostatek peněz");
            return;
        }

        moneyTransferService.subMoney(account, amount);
        System.out.println("Častka vybrána: " + amount);
    }
}
