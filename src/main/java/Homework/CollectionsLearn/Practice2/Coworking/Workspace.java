package Homework.CollectionsLearn.Practice2.Coworking;

public class Workspace implements Comparable<Workspace> {
    @Override
    public int compareTo(Workspace o) {
        int numSpace;
        if (o.numSpace == this.numSpace) {
            return 0;
        }else if (o.numSpace < this.numSpace) {
            return 1;
        }else {
            return -1;
        }
    }

    private int numSpace;
    private String type;
    private boolean isAvailable;

    public Workspace(int numSpace, String type, boolean isAvailable) {
        this.numSpace = numSpace;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public int getNumSpace() {
        return numSpace;
    }

    public void setNumSpace(int numSpace) {
        this.numSpace = numSpace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void markAsAvailable() {
        this.isAvailable = true;
    }
    public void markAsBooked() {
        this.isAvailable = false;
    }
    public String toString(){
        return "Workspace [numSpace=" + numSpace + ", type=" + type + ", isAvailable=" + isAvailable + "]";
    }
}
