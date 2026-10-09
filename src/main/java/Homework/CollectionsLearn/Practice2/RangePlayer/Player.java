package Homework.CollectionsLearn.Practice2.RangePlayer;

import java.util.Objects;

public abstract class Player {
    private int id;
    private String name;
    private int rating;

    public Player(String name, int id, int rating) {
        this.name = name;
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean equals(){
        return true;
    }
    public int hashCode(){

        return Objects.hash(id, name, rating);
    }
    public String toString(){
        return this.getName() +"\n";
    }

}
