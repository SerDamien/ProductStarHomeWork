package Homework.WorkWithFile.Practice1;

import java.io.Serializable;

public class DestinationDot implements Serializable {

    private static final long serialVersionUID = 1L;
    private String destination;
    public DestinationDot(){};
    public DestinationDot(String destination) {
        this.destination = destination;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
