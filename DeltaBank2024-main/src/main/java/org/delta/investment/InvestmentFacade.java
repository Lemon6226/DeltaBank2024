package org.delta.investment;
import com.google.inject.Inject;
import org.delta.acounts.BankAccount;
import org.delta.acounts.BankAccountFacade;
import org.delta.acounts.MoneyTransferService;

import java.util.ArrayList;
import java.util.List;

public class InvestmentFacade {

    private final org.delta.investment.InvestmentFactory investmentFactory;
    private List<InvestmentService> investments;

    private final BankAccountFacade bankAccountFacade;
    private final MoneyTransferService moneyTransferService;

    @Inject
    public InvestmentFacade(InvestmentFactory investmentFactory, BankAccountFacade bankAccountFacade, MoneyTransferService moneyTransferService) {
        this.investmentFactory = investmentFactory;
        this.bankAccountFacade = bankAccountFacade;
        this.moneyTransferService = moneyTransferService;
    }

    public List<InvestmentService> createInvestments(double totalAmount) {
        InvestmentService appleInvestment = investmentFactory.createAppleInvestment(totalAmount);
        InvestmentService alphabetInvestment = investmentFactory.createAlphabetInvestment(totalAmount);
        InvestmentService metaInvestment = investmentFactory.createMetaInvestment(totalAmount);
        investments.add(appleInvestment);
        investments.add(alphabetInvestment);
        investments.add(metaInvestment);
        return investments;
    }

    public double calculateTotalReturn() {
        double totalReturn = 0;
        for (InvestmentService investment : investments) {
            totalReturn += investment.calculateReturn();
        }
        return totalReturn;
    }

    public List<InvestmentService> getInvestments() {
        return investments;
    }

    public void addInvestmentsToBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();

        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount instanceof InvestmentBankAccount) {
                InvestmentBankAccount investmentBankAccount = (InvestmentBankAccount) bankAccount;

                List<InvestmentService> investments = investmentBankAccount.getInvestments();

                double totalReturn = 0;
                for (InvestmentService investment : investments) {
                    totalReturn += investment.calculateReturn();
                }

                System.out.println("Výdělek:" + totalReturn + " Na účet: " + bankAccount.getAccountNumber());
                moneyTransferService.addMoney(bankAccount, totalReturn);
            }
        }
    }
}