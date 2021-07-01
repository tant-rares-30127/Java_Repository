
package isp.lab6.exercise3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SensorsCluster {
    private List<Sensor> sensorList=new ArrayList<>();
    
    public Sensor addSensor(String sensorId, SENSOR_TYPE type){
        if (sensorList.stream().noneMatch(sensor->sensor.getId().equals(sensorId))){
            Sensor sensor=new Sensor(type, sensorId);
            sensorList.add(sensor);
            return sensor;
        }
        return null;
    }
    
    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime){
        Sensor sensor=sensorList.stream().filter(k-> sensorId.equals(k.getId())).findFirst().orElse(null);
        if (sensor==null) return false;
        else{
            SensorReading sensorReading = new SensorReading(dateTime, value);
            sensor.addSensorReading(sensorReading);
            return true;
        }
    }
    
    public Sensor getSensorById(String sensorId){
        Sensor sensor=sensorList.stream().filter(k-> sensorId.equals(k.getId())).findFirst().orElse(null);
        System.out.println("The sensor "+sensorId+" readings sorted by time are:");
        for (SensorReading s: sensor.getSensorReadingSortedByDateAndTime()){
            System.out.println(s.toString());
        }
        System.out.println("The sensor "+sensorId+" readings sorted by value are:");
        for (SensorReading s: sensor.getSensorReadingSortedByValue()){
            System.out.println(s.toString());
        }
        return sensor;
    }
}
