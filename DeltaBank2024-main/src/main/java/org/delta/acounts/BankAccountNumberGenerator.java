package org.delta.acounts;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankAccountNumberGenerator implements AccountNumberGenerator {

    private static final byte BASE_ACCOUNT_NUMBER_LENGTH = 10;

    @Override
    public String generateBankAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();
        accountNumber.append(random.nextInt(9) + 1);

        for (int i = 1; i < BASE_ACCOUNT_NUMBER_LENGTH; i++) {
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }

}
