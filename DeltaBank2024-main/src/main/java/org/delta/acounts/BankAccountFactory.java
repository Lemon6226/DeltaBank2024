package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;


    public BankAccount createBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(Owner owner, double balance, String bankAccountNumber) {
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new SavingBankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance, String studentStudiesConfirmationExpire) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, bankAccountNumber, studentStudiesConfirmationExpire);
    }
}
