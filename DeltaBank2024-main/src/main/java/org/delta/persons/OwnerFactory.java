package org.delta.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.AccountNumberGenerator;
import org.delta.acounts.BankAccountNumberGenerator;

@Singleton
public class OwnerFactory {

    @Inject
    private PersonIdValidator personIDValidator;
    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;


    public Owner createOwner(String firstName, String lastName, String id) throws Exception {

        if (!this.personIDValidator.isPersonIdValid((id))){
            throw new Exception("Id not valid.");
        }
        return new Owner(firstName, lastName, id);
    }
}

