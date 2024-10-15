package org.delta.print;

import org.delta.acounts.BankAccount;
import org.delta.acounts.SavingBankAccount;
import org.delta.acounts.StudentBankAccount;

public class PrinterUtils {
    private PrinterUtils() {}

    public static String getPrefix(BankAccount account) {
        if (account instanceof StudentBankAccount) {
            return "Student ";
        }

        if (account instanceof SavingBankAccount) {
            return "Saving ";
        }

        return "";
    }
}
