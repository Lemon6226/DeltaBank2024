package org.delta.print;

import org.delta.acounts.BankAccount;

public interface DetailPrinter {
    public void printDetail(BankAccount account, double fee);
    public void printDetail(BankAccount account);
}
