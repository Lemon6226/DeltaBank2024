package org.delta.acounts;

import com.google.inject.Singleton;

public class SlovakiaBankAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    @Singleton
    public String generateBankAccountNumber() {
        return "SLOVAKIA BANK ACCOUNT NUMBER";
    }
}
