package org.delta.acounts;

import org.delta.acounts.BankAccount;
import java.util.List;

public class InterestCalculator {


    public double calculateInterest(double balance, double rate) {
        return balance * rate;
    }

    public void applyInterest(BankAccount account) {
        double interest;
        if (account instanceof SavingBankAccount) {
            double savingRate = ((SavingBankAccount) account).getInterest();
            interest = calculateInterest(account.getBalance(), savingRate);
        } else {
            interest = calculateInterest(account.getBalance(), 0.02);
        }

        double newBalance = account.getBalance() + interest;
        account.setBalance(newBalance);
    }
}