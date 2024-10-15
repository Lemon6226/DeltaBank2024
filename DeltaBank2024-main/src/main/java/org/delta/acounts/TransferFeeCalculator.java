package org.delta.acounts;

public class TransferFeeCalculator {

    public static final double DEFAULT_TRANSFER_FEE = 10;
    public static final double SECOND_LEVEL_FEE_LIMIT = 500;

    public double calculateFee(double amount) {
        double fee = DEFAULT_TRANSFER_FEE;
        if (amount >= SECOND_LEVEL_FEE_LIMIT) {
            fee += amount / 100;
        }

        return fee;
    }

}
