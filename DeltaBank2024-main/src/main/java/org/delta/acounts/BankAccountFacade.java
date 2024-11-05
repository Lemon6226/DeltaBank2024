package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.BankAccount;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class BankAccountFacade {
    private List<BankAccount> bankAccounts = new LinkedList<>();

    @Inject
    private org.delta.acounts.BankAccountFactory bankAccountFactory;

    public BankAccount createBankAccount(Owner owner, double balance) {
        BankAccount bankAccount = this.bankAccountFactory.createBankAccount(owner, balance);
        this.bankAccounts.add(bankAccount);
        return bankAccount;
    }


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance, String expire) {
        BankAccount account = this.bankAccountFactory.createStudentBankAccount(owner, balance, expire);
        this.bankAccounts.add(account);
        return account;
    }
    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        BankAccount account = this.bankAccountFactory.createSavingBankAccount(owner, balance);
        this.bankAccounts.add(account);
        return account;
    }


}