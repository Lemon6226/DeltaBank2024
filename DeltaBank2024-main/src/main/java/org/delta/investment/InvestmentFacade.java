package org.delta.investment;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class InvestmentFacade {

    private org.delta.investment.InvestmentFactory investmentFactory;
    private List<Investment> investments;

    @Inject
    public InvestmentFacade(org.delta.investment.InvestmentFactory investmentFactory) {
        this.investmentFactory = investmentFactory;
        this.investments = new ArrayList<>();
    }

    public List<Investment> createInvestments(double totalAmount) {
        Investment appleInvestment = investmentFactory.createAppleInvestment(totalAmount);
        Investment alphabetInvestment = investmentFactory.createAlphabetInvestment(totalAmount);
        Investment metaInvestment = investmentFactory.createMetaInvestment(totalAmount);
        investments.add(appleInvestment);
        investments.add(alphabetInvestment);
        investments.add(metaInvestment);
        return investments;
    }

    public double calculateTotalReturn() {
        double totalReturn = 0;
        for (Investment investment : investments) {
            totalReturn += investment.calculateReturn();
        }
        return totalReturn;
    }

    public List<Investment> getInvestments() {
        return investments;
    }
}