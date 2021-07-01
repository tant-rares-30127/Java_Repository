package isp.lab6.exercise3;

import java.time.LocalDateTime;

public class SensorReading implements Comparable<SensorReading> {
    
    private LocalDateTime dateAndTime;
    private double value;

    @Override
    public int compareTo(SensorReading s){
        return this.dateAndTime.compareTo(s.dateAndTime);
    }
    
    public SensorReading(LocalDateTime dateAndTime, double value) {
        this.dateAndTime = dateAndTime;
        this.value = value;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SensorReading{" + "dateAndTime=" + dateAndTime + ", value=" + value + '}';
    }
    
}
