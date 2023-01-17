package Serialization;

import User.UserDataBase;
import User.UserLoginBase;

import java.util.HashMap;

public abstract class SerializeUserLoginBase extends Serialization{
    private static final String FILE_NAME = "PassSerialization.ser";

    public static void serialize(){
        serialize(UserLoginBase.getUserHashMap(), FILE_NAME);
    }

    public static HashMap deserialize(){
        return deserialize(FILE_NAME);
    }
}
