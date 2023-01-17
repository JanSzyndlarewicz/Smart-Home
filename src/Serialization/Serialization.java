package Serialization;

import java.io.*;
import java.util.HashMap;

public abstract class Serialization {

    public static void serialize(HashMap<String, ?> userDataBase, String fileName){
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream(fileName))) {
            so.writeObject(userDataBase);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap deserialize(String fileName){
        HashMap deserialized = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
            deserialized = (HashMap) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserialized;
    }

}
