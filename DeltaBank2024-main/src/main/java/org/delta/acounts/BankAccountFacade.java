package org.delta.accounts;

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
    private org.delta.accounts.BankAccountFactory bankAccountFactory;

    public BankAccount createBankAccount(Owner owner, double balance) {
        BankAccount bankAccount = this.bankAccountFactory.createBankAccount(owner, balance);
        this.bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}