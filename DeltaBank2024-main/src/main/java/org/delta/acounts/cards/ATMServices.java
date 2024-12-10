package org.delta.acounts.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.BankAccountFacade;
import org.delta.acounts.BankAccount;
import org.delta.acounts.MoneyTransferService;
import org.delta.acounts.cards.BankCard;

import java.util.List;

@Singleton
public class ATMServices {

    @Inject
    BankAccountFacade bankAccountFacade;

    @Inject
    MoneyTransferService moneyTransferService;

    public void getMoneyFromCard(String cardNumber, String pin, int money) throws Exception {
        BankCard card = findBankCard(cardNumber);
        BankAccount owner = card.getOwner();

        if (!card.getPin().equals(pin)) {
            throw new Exception("Invalid pin.");
        }

        if (owner.getBalance() < money) {
            throw new Exception("Insufficient balance.");
        }

        moneyTransferService.subMoney(owner, money);
    }

    public void getMoneyFromCardToOtherAccount(String cardNumber, String pin, int money, String receivingAccountNumber) throws Exception {
        BankCard card = findBankCard(cardNumber);
        BankAccount owner = card.getOwner();

        if (!card.getPin().equals(pin)) {
            throw new Exception("Invalid pin.");
        }

        if (owner.getBalance() < money) {
            throw new Exception("Insufficient balance.");
        }

        moneyTransferService.subMoney(owner, money);

        BankAccount receivingAccount = findBankAccount(receivingAccountNumber);
        moneyTransferService.addMoney(receivingAccount, money);
    }

    private BankCard findBankCard(String cardNumber) throws Exception {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();

        for (BankAccount bankAccount : bankAccountList) {
            System.out.println("Checking account: " + bankAccount.getAccountNumber());
            System.out.println("Available cards: " + bankAccount.getAllCards().keySet());
            BankCard card = bankAccount.getCard(cardNumber);
            if (card != null) {
                return card;
            }
        }

        throw new Exception("Card not found " + cardNumber);
    }

    private BankAccount findBankAccount(String accountNumber) throws Exception {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();

        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }

        throw new Exception("Bank account not found.");
    }
}