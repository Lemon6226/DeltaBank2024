package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.cards.BankCard;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.Map;
import java.lang.Iterable;

@Singleton
public class BankAccount {

    private double balance;
    private Owner owner;
    private String accountNumber;
    private Map<String, BankCard> cards = new HashMap<>();


    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //přidá kartu
    public void addCard(BankCard card) {
        cards.put(card.getNumber(), card);
    }

    //sebere kartu
    public void removeCard(String cardNumber) {
        cards.remove(cardNumber);
    }

    //vezme kartu s číslem
    public BankCard getCard(String cardNumber) {
        return cards.get(cardNumber);
    }

    //vezme všechny karty
    public Map<String, BankCard> getAllCards() {
        return cards;
    }

    public void getInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Owner: " + owner.getName());
        System.out.println("Cards: ");

        for (BankCard card : cards.values()) {
            System.out.println(card.getNumber());
        }
    }

    public int getAmountOfBankCards(){
        return cards.size();
    }

    public void assignNewCard(BankCard bankCard){
        cards.put(bankCard.getNumber(), bankCard);
    }
}