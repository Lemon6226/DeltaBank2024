package org.delta.persons;


import com.google.gson.Gson;

public class PersonGsonSerializationService implements PersonSerializationService {
    public String serializeOwner(Owner owner) {
        Gson gson = new Gson();

        return gson.toJson(owner, Owner.class);
    }
}
