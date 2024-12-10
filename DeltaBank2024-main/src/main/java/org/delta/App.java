package org.delta;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.delta.acounts.*;
import org.delta.acounts.cards.ATMServices;
import org.delta.acounts.cards.BankCard;
import org.delta.acounts.cards.BankCardGenerator;
import org.delta.acounts.exceptions.NoMoneyOnAccountException;
import org.delta.investment.InvestmentBankAccount;
import org.delta.investment.InvestmentService;
import org.delta.investment.InvestmentFacade;
import org.delta.investment.InvestmentFactory;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIdValidator;
import org.delta.print.DetailPrinter;
import org.delta.service.SerializationService;

import java.util.ArrayList;
import java.util.List;


public class App {

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private org.delta.acounts.BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardGenerator bankCardGenerator;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private ATMServices atmServices;

    @Inject
    private InvestmentFacade investmentFacade;

    @Inject
    private InvestmentFactory investmentFactory;

    @Inject
    private SerializationService serializationService;


    private static final String BANK_ACCOUNTS_FILE = "C:\\Users\\vendu\\OneDrive\\Plocha\\DeltaBank2024-main\\DeltaBank2024-main\\src\\main\\java\\org\\delta\\bankAccounts.ser";


    public void run() throws Exception {
        Owner owner = ownerFactory.createOwner("Tomas", "Pešek", "123");
        BankAccount account = bankAccountFactory.createBankAccount(owner, 500);
        BankCard card = bankCardGenerator.createBankCard(account, "1234");
        account.addCard(card);
        System.out.println("Added card: " + card.getNumber());
        System.out.println("Account cards: " + account.getAllCards().keySet());

        testSerialization(owner, account);
    }

    private void testSerialization(Owner owner, BankAccount account) throws Exception {
        // vytvoří účty
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(bankAccountFactory.createStudentBankAccount(owner, 1500, "2025-12-31"));
        accounts.add(bankAccountFactory.createSavingBankAccount(owner, 2000));

        //uloží účty do file
        serializationService.serializeToFile(accounts, BANK_ACCOUNTS_FILE);

        // vezme si data z file
        List<BankAccount> loadedAccounts = serializationService.deserializeFromFile(BANK_ACCOUNTS_FILE, List.class);

        // vypíše účty
        for (BankAccount acc : loadedAccounts) {
            acc.getInfo();
        }

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
