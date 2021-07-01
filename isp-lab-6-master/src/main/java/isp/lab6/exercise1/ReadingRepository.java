package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReadingRepository implements IReadingRepository{

    List <SensorReading> sensorList = new ArrayList<>();
    
    @Override
    public void addReading(SensorReading reading) {
        sensorList.add(reading);
    }

    @Override
    public double getAvarageValueByType(Type type, String location) {
        double average=0;
        double nrofreadings=0;
        
        for (SensorReading s : sensorList){
            if (s.getLocation().equals(location))
                if (s.getType().equals(type)){
                    average=average+s.getValue();
                    nrofreadings++;
                }
        }
        average=average/nrofreadings;
        
        return average;
    }

    @Override
    public List<SensorReading> getReadingsByType(Type type) {
        List<SensorReading> sensorTypeList = new ArrayList<>();
        
        for (SensorReading s: sensorList){
            if (s.getType().equals(type)){
                sensorTypeList.add(s);
            }
        }
        
        return sensorTypeList;
    }

    @Override
    public void listSortedByLocation() {
        
        Collections.sort(sensorList, new Sortbylocation());
        int i=1;
        for (SensorReading s: sensorList){
            System.out.println(i+s.toString());
            i++;
        }
        
    }

    @Override
    public void listSortedByValue() {
        
        Collections.sort(sensorList, new Sortbyvalue());
        int i=1;
        for (SensorReading s: sensorList){
            System.out.println(i+s.toString());
            i++;
        }
        
    }

    @Override
    public List<SensorReading> findAllByLocationAndType(String location, Type type) {
        List<SensorReading> sensorFiltredList = new ArrayList<>();
        
        for (SensorReading s: sensorList){
            if (s.getType().equals(type))
                if (s.getLocation().equals(location)){
                    sensorFiltredList.add(s);
            }
        }
        
        return sensorFiltredList;
    }
    
}

class Sortbylocation implements Comparator<SensorReading> {
    // Used for sorting in ascending order of
    // name
    @Override
    public int compare(SensorReading a, SensorReading b)
    {
        return a.getLocation().compareTo(b.getLocation());
    }
}

class Sortbyvalue implements Comparator<SensorReading> {
    // Used for sorting in ascending order of
    // name
    @Override
    public int compare(SensorReading a, SensorReading b)
    {
        return a.getValue()-b.getValue();
    }
}