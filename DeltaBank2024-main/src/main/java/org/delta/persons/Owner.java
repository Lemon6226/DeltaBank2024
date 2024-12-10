package org.delta.persons;

import java.io.Serializable;

public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String surname;

    private String personId;


    public Owner(String name, String surname, String personId) {
        this.name = name;
        this.surname = surname;
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonId(){
        return getPersonId();
    }
}