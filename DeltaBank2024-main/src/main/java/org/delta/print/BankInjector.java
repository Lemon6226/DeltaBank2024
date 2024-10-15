package org.delta.print;

import com.google.inject.AbstractModule;
import org.delta.acounts.AccountNumberGenerator;
import org.delta.acounts.SlovakiaBankAccountNumberGenerator;

public class BankInjector extends AbstractModule{

    @Override
    protected void configure(){
    this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
    }
}
