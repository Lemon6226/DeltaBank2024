package org.delta;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.delta.acounts.*;
import org.delta.acounts.cards.BankCardGenerator;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIdValidator;
import org.delta.persons.PersonJsonSerializationService;
import org.delta.print.DetailPrinter;
import org.delta.print.SlfAccountDetailPrinted;
@Singleton
public class DIContainer {

    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private DetailPrinter accountDetailPrinter = new SlfAccountDetailPrinted();
    private PersonIdValidator personIdValidator = new PersonIdValidator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);
    private BankAccountFactory bankAccountFactory;
    private BankCardGenerator bankCardGenerator;

    public AccountNumberGenerator getBankAccountNumberGenerator() {
        return bankAccountNumberGenerator;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public DetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public PersonIdValidator getPersonIdValidator() {
        return personIdValidator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public BankCardGenerator getBankCardGenerator() {
        return bankCardGenerator;
    }
}
