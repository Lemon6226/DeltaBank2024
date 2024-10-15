package org.delta.acounts.exceptions;

public class NoMoneyOnAccountException extends Exception {

    public NoMoneyOnAccountException(String message) {
        super(message);
    }
}
