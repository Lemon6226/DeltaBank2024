package org.delta.persons;

public class PersonJsonSerializationService {
    public String serializeOwner(Owner owner){
        StringBuilder str = new StringBuilder();

        str.append("{");
        str.append("\"name\"");
        str.append(owner.getName());
        str.append("\n");

        str.append("\"lastName\"");
        str.append(owner.getSurname());
        str.append("\n");

        str.append("\"personId\"");
        str.append(owner.getPersonId());
        str.append("\n");
        
        str.append("}");

        return(str.toString());
    }
}
