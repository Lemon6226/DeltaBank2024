package org.delta.service;

import java.io.*;

public class SerializationService {

    public <T> void serializeToFile(T object, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
        }
    }

    public <T> T deserializeFromFile(String filePath, Class<T> type) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return type.cast(ois.readObject());
        }
    }
}
