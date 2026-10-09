package Homework.CollectionsLearn.Practice2.RangePlayer;

public class Main {
    public static void main(String[] args) {
        GamePlayer player1 = new GamePlayer("player 1", 1, 5, "Dota");
        GamePlayer player2 = new GamePlayer("player 2 ", 2, 3, "Dota");
        GamePlayer player3 = new GamePlayer("player 3", 3, 4, "Dota");

        RankingSystem rankingSystem = new RankingSystem();

        rankingSystem.addPlayer(player1);
        rankingSystem.addPlayer(player2);
        rankingSystem.addPlayer(player3);

        rankingSystem.getTopPlayer(3);

        System.out.println(rankingSystem.getTopPlayer(3).toString());

        System.out.println(rankingSystem.getPlayerRank(2));

        rankingSystem.updatePlayerRanking(5, 6);

        System.out.println(rankingSystem.getTopPlayer(3).toString());

        rankingSystem.showRanking();

    }
}
