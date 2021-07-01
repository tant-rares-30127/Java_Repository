package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        Type pressure = Type.PRESSURE;
        Type temperature = Type.TEMPERATURE;
        Type humidity = Type.HUMIDITY;
        SensorReading s1 = new SensorReading(200, "Sufragerie", pressure);
        SensorReading s2 = new SensorReading(22, "Sufragerie", temperature);
        SensorReading s3 = new SensorReading(24, "Dormitor", temperature);
        SensorReading s4 = new SensorReading(1, "Garaj", humidity);
        SensorReading s5 = new SensorReading(22, "Dormitor", temperature);
        ReadingRepository rr= new ReadingRepository();
        rr.addReading(s1);
        rr.addReading(s2);
        rr.addReading(s3);
        rr.addReading(s4);
        rr.addReading(s5);
        System.out.println("Average Value by temperature in Dormitor"
                +rr.getAvarageValueByType(temperature, "Dormitor"));
        
        List <SensorReading> sensorList = new ArrayList<>();
        
        sensorList=rr.getReadingsByType(temperature);
        for (SensorReading s : sensorList) System.out.println(s.toString());
        
        rr.listSortedByLocation();
        
        rr.listSortedByValue();
        
        sensorList=rr.findAllByLocationAndType("Dormitor", temperature);
        for (SensorReading s : sensorList) System.out.println(s.toString());
    }
}
