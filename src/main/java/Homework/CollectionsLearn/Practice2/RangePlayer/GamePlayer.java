package Homework.CollectionsLearn.Practice2.RangePlayer;

public class GamePlayer extends Player {
    private String game;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public GamePlayer(String name, int id, int rating, String game) {
        super(name, id, rating);
        this.game = game;
    }


}
