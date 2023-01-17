package Serialization;

import User.User;
import User.UserDataBase;
import User.UserLoginBase;
import java.util.HashMap;

public abstract class SerializationFunc {
    public static void serialize(){
        SerializeUserDataBase.serialize();
        SerializeUserLoginBase.serialize();
    }

    public static void deserialize(){
        UserDataBase.setUserDataBase(SerializeUserDataBase.deserialize());
        UserLoginBase.setUserHashMap(SerializeUserLoginBase.deserialize());
    }
}
