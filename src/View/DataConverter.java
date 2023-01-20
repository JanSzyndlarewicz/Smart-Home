package View;

import Device.Device;

import java.util.ArrayList;

public abstract class DataConverter {
    private static <T> Object[][] returnFormat( ArrayList< T> wynik) {
        Object[][] result= new Object[wynik.size()][];

        for (int i = 0; i < wynik.size(); i++)
            result[i] = (Object[]) wynik.get(i);

        return result;
    }

    public static Object[][] returnDevTabFormat(ArrayList<Device> devices) {
        ArrayList< Object[]> result=new ArrayList<Object[]>() ;


        for (int i = 0; i < devices.size(); i++)

                result.add(new Object[]{i,devices.get(i).getAlias(),devices.get(i).getLocation()});


        return returnFormat(result);
    }
}
