package org.delta;

import com.google.inject.Inject;
import org.delta.acounts.*;
import org.delta.acounts.cards.BankCard;
import org.delta.acounts.cards.BankCardGenerator;
import org.delta.acounts.exceptions.NoMoneyOnAccountException;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIdValidator;
import org.delta.print.DetailPrinter;

public class App {

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private org.delta.accounts.BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardGenerator bankCardGenerator;

    @Inject
    private MoneyTransferService moneyTransferService;


    public void run() throws Exception {
        Owner owner = ownerFactory.createOwner("Tomas", "Pesek", "123");
        BankAccount account = bankAccountFactory.createBankAccount(owner, 500);
        BankCard card = bankCardGenerator.createBankCard("1234");
        account.addCard(card);
        System.out.println("Card Number: " + card.getNumber());
        System.out.println("Card PIN: " + card.getPin());
    }

    private void testBank() throws Exception {

        Owner owner = this.ownerFactory.createOwner("Tomas", "Pesek", "123");
        BankAccount accountOne = this.bankAccountFactory.createBankAccount(owner, 500);
        BankAccount accountTwo = this.bankAccountFactory.createStudentBankAccount(owner, 1500, "expirace");
        BankAccount accountThree = this.bankAccountFactory.createSavingBankAccount(owner, 1500);



        // test
        if (accountTwo instanceof StudentBankAccount) {
            String expire = ((StudentBankAccount) accountTwo).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }

        if (accountThree instanceof Interesting) {
            double interest = ((Interesting) accountThree).getInterest();
            System.out.println(interest);
        }

        System.out.println("Bank account balance: " + accountOne.getBalance());

        this.moneyTransferService.addMoney(accountOne, 100);
        this.moneyTransferService.addMoney(accountOne, 10);
        this.moneyTransferService.addMoney(accountOne, 600);
        this.moneyTransferService.subMoney(accountOne, 150);

        this.moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
    }

    private void testNum() {
        int a = 10;
        int b = 10;
        System.out.println(a + b);
    }

    private void testStrings() {
        String text = "Toto je testovací řetězec";
        System.out.println(text.length());

        char searchChar = 'a';
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == searchChar) {
                counter++;
            }
        }
        System.out.println("pocet a: " + counter);
    }

    private void testFor() {
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    private void testCalc() {
        Calc calculator = new Calculator();

        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.sub(10, 20));
        System.out.println(calculator.mul(10, 20));
        System.out.println(calculator.div(10, 0));
    }
}
