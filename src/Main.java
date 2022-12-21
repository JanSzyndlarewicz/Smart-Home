import Device.Bulb.BulbRGBW;
import Device.Device;

public class Main {
    public static void main(String[] args) {
        Device x;
        x = new BulbRGBW(-10, 10, 20, 30);
        System.out.println(x);
    }
}