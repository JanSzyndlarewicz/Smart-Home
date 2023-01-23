package Main;
import Serialization.SerializationFunc;
import View.StartFrame;

public class Main {
    public static void main(String[] args) {

        SerializationFunc.deserialize();
        StartFrame startFrame = new StartFrame();

    }
}