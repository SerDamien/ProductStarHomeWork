package Homework.WorkWithFile.Practice1;

import javax.print.attribute.standard.Destination;
import java.io.Serializable;
import java.util.UUID;

public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String road;
    private DestinationDot destination;
    private int time;

    public Trip(){};

    public Trip(String road) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.road = road;
        this.time = (int) (((12 - 1) + 1) * Math.random()) + 1;
        //System.out.println(id + " " + time);
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public DestinationDot getDestination() {
        return destination;
    }

    public void setDestination(DestinationDot destination) {
        this.destination = destination;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
