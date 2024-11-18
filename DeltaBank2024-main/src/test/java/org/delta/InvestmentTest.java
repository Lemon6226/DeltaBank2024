package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.acounts.BankAccountFacade;
import org.delta.investment.InvestmentBankAccount;
import org.delta.investment.InvestmentFacade;
import org.delta.investment.InvestmentService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestmentTest {

    private Injector injector;
    private OwnerFactory ownerFactory;
    private BankAccountFacade accountFacade;
    private InvestmentFacade investmentFacade;

    @BeforeEach
    void setUp() {
        injector = Guice.createInjector(new BankInjector());
        ownerFactory = injector.getInstance(OwnerFactory.class);
        accountFacade = injector.getInstance(BankAccountFacade.class);
        investmentFacade = injector.getInstance(InvestmentFacade.class);
    }

    @Test
    @DisplayName("Validate Investment Returns Added to Bank Accounts")
    void testInvestmentReturns() throws Exception {

        Owner testOwner = ownerFactory.createOwner("Tomas", "Pesek", "123");
        InvestmentBankAccount investmentAccount = (InvestmentBankAccount) accountFacade.createBankAccount(testOwner, 5000);

        List<InvestmentService> investments = investmentFacade.createInvestments(investmentAccount.getBalance());
        for (InvestmentService investment : investments) {
            investmentAccount.addInvestment(investment);
        }

        //kolik by se mělo vracet peněz
        double expectedReturns = investments.stream().mapToDouble(InvestmentService::calculateReturn).sum();

        investmentFacade.addInvestmentsToBankAccounts();


        double expectedBalance = 5000 + expectedReturns;
        assertEquals(expectedBalance, investmentAccount.getBalance(), 0.01);
    }
}
