package Serialization;

import Home.Home;
import User.UserDataBase;

import java.io.*;

public class Serialization {

    private static UserDataBase deserializedUserDataBase;



    public static void serialize(UserDataBase userDataBase){
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("UserSerialization.ser")))
        {
            so.writeObject(userDataBase);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("UserSerialization.ser"))) {

            deserializedUserDataBase = (UserDataBase) is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static UserDataBase getDeserializedHome() {
        return deserializedUserDataBase;
    }

    public static void setDeserializedHome(UserDataBase userDataBase) {
        Serialization.deserializedUserDataBase = userDataBase;
    }
}
