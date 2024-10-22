package org.delta.print;

import com.google.inject.Singleton;
import org.delta.acounts.BankAccount;


public class ConsoleDetailPrinter implements DetailPrinter {


    public void printDetail(BankAccount account) {
        System.out.println("Account balance: " + account.getBalance());
    }


    public void printDetail(BankAccount account, double fee) {
        System.out.println("Account balance: " + account.getBalance() + ", Transfer fee: " + fee);
    }

}