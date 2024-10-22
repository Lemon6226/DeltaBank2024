package org.delta.print;

import com.google.inject.AbstractModule;
import org.delta.acounts.AccountNumberGenerator;
import org.delta.acounts.SlovakiaBankAccountNumberGenerator;
import org.delta.acounts.TransferFeeCalculator;
import org.delta.print.DetailPrinter;
import org.delta.print.ConsoleDetailPrinter;

public class BankInjector extends AbstractModule{

    @Override
    protected void configure(){
    this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
    this.bind(DetailPrinter.class).to(ConsoleDetailPrinter.class);
    this.bind(TransferFeeCalculator.class).asEagerSingleton();
    }
}
