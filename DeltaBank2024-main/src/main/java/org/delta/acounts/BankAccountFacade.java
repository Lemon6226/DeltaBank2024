package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.BankAccount;
import org.delta.persons.Owner;
import org.delta.service.SerializationService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class BankAccountFacade {
    private List<BankAccount> bankAccounts = new LinkedList<>();

    //*
    @Inject private SerializationService serializationService;
    private static final String BANK_ACCOUNTS_FILE = "bankAccounts.ser";

    public void saveAccountsToFile() {
        try {
            serializationService.serializeToFile(bankAccounts, BANK_ACCOUNTS_FILE);
            System.out.println("Účty uloženy");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Chyba při uložení účtů");

        }
    }

    public void loadAccountsFromFile() {
        try {
            List<BankAccount> loadedAccounts = serializationService.deserializeFromFile(BANK_ACCOUNTS_FILE, List.class);
            bankAccounts.clear();
            bankAccounts.addAll(loadedAccounts);
            System.out.println("Účty načtený");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Chyba při načtení účtů");
        }
    }
   //*


    @Inject
    private org.delta.acounts.BankAccountFactory bankAccountFactory;

    public BankAccount createBankAccount(Owner owner, double balance) {
        BankAccount account = bankAccountFactory.createBankAccount(owner, balance);
        bankAccounts.add(account);
        System.out.println("Registered new account: " + account.getAccountNumber());
        return account;
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