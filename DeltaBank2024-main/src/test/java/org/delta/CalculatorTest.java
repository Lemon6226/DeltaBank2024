package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.acounts.BankAccount;
import org.delta.acounts.BankAccountFacade;
import org.delta.acounts.BankAccountFactory;
import org.delta.acounts.cards.BankCard;
import org.delta.acounts.cards.BankCardFactory;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    Injector i = Guice.createInjector(new BankInjector());

    private OwnerFactory ownerFactory;
    private BankAccountFactory bankAccountFactory;
    private BankCardFactory bankCardFactory;

    @BeforeEach
    void setUp(){
        this.bankCardFactory = i.getInstance(BankCardFactory.class);
        this.ownerFactory = i.getInstance(OwnerFactory.class);
        this.bankAccountFactory = i.getInstance(BankAccountFactory.class);
    }

    @Test
    @DisplayName("Bank card genereted test")
    void createBankCard() throws Exception {
        Owner ownerTest = this.ownerFactory.createOwner("Tomas", "Pesek","123");

        assertEquals(ownerTest.getName(),"Tomas");
        assertEquals(ownerTest.getSurname(),"Tomas");
        assertEquals(ownerTest.getPersonId(),"123");

        BankAccount testbankAccount = this.bankAccountFactory.createBankAccount(ownerTest,1000);
        assertEquals(testbankAccount.getBalance(),1000);

        BankCard bankCardTest = this.bankCardFactory.createBankCard(testbankAccount);


    }
}
