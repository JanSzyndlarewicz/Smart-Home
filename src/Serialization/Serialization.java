package Serialization;

import Home.Home;

import java.io.*;

public class Serialization {

    private static Home deserializedHome;



    public static void serialize(Home home){
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Serialization.ser")))
        {
            so.writeObject(home);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Serialization.ser"))) {

            Home home = (Home) is.readObject();

            deserializedHome = home;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static Home getDeserializedHome() {
        return deserializedHome;
    }

    public static void setDeserializedHome(Home dehome) {
        Serialization.deserializedHome = dehome;
    }
}
