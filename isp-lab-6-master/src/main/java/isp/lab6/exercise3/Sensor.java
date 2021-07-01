package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sensor {
    private SENSOR_TYPE type;
    private String id;
    private List<SensorReading> sensorReadingList = new ArrayList<>();

    public Sensor(SENSOR_TYPE type, String id) {
        this.type = type;
        this.id = id;
    }
    
    public List<SensorReading> getSensorReadingSortedByValue(){
        Collections.sort(sensorReadingList, new SortbyValue());
        return sensorReadingList;
    }
    
    public List<SensorReading> getSensorReadingSortedByDateAndTime(){
        Collections.sort(sensorReadingList);
        return sensorReadingList;
    }
    
    public void addSensorReading(SensorReading sr){
        sensorReadingList.add(sr);
    }

    public String getId() {
        return id;
    }

}

class SortbyValue implements Comparator<SensorReading> {
    // Used for sorting in ascending order of
    // name
    @Override
    public int compare(SensorReading a, SensorReading b)
    {
        return Double.compare(a.getValue(), b.getValue());
    }
}
