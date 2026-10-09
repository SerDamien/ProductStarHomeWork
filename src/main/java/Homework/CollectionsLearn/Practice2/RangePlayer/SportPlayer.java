package Homework.CollectionsLearn.Practice2.RangePlayer;

public class SportPlayer extends Player {
    private String sport;

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public SportPlayer(String name, int id, int rating, String sport) {
        super(name, id, rating);
        this.sport = sport;
    }

}
