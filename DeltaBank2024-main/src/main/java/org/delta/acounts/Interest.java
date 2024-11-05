package org.delta.acounts;

import com.google.inject.Inject;
import java.util.List;

public class Interest {

    private final InterestCalculator interestCalculator;
    private final BankAccountFacade bankAccountFacade;

    @Inject
    public Interest(InterestCalculator interestCalculator, BankAccountFacade bankAccountFacade) {
        this.interestCalculator = interestCalculator;
        this.bankAccountFacade = bankAccountFacade;
    }

    public void addInterestToBankAccounts() {
        List<BankAccount> accounts = bankAccountFacade.getBankAccounts();

        for (BankAccount account : accounts) {
            interestCalculator.applyInterest(account);
        }
    }
}