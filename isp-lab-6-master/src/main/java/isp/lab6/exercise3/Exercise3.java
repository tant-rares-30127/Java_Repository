package isp.lab6.exercise3;

import java.time.LocalDateTime;

public class Exercise3 {

    public static void main(String[] args) {
        SensorsCluster sensorCluster=new SensorsCluster();
        
        sensorCluster.addSensor("123", SENSOR_TYPE.TEMPERATURE);
        if (sensorCluster.addSensor("123", SENSOR_TYPE.TEMPERATURE)==null) System.out.println("This sensor already exists");
        sensorCluster.addSensor("125", SENSOR_TYPE.PRESSURE);
        sensorCluster.addSensor("122", SENSOR_TYPE.HUMIDITY);
        sensorCluster.writeSensorReading("125", 100, LocalDateTime.parse("2021-03-25T13:25:00"));
        sensorCluster.writeSensorReading("125", 108, LocalDateTime.parse("2021-02-13T19:34:00"));
        sensorCluster.writeSensorReading("123", 25, LocalDateTime.parse("2021-04-19T19:34:00"));
        sensorCluster.writeSensorReading("123", 24, LocalDateTime.parse("2021-05-05T19:34:00"));
        sensorCluster.writeSensorReading("122", 5, LocalDateTime.parse("2021-05-05T19:34:00"));
        
        if (!sensorCluster.writeSensorReading("127", 5, LocalDateTime.parse("2021-05-05T19:34:00"))) System.out.println("This sensor doesn't exists");
        
        sensorCluster.getSensorById("125");
        sensorCluster.getSensorById("123");
    }
}
