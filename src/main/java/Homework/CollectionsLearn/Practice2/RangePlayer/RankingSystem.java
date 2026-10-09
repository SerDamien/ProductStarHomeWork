package Homework.CollectionsLearn.Practice2.RangePlayer;

import java.util.*;

public class RankingSystem {
    TreeMap<Integer, Set<Player>> gamePlayRanking;
    public RankingSystem() {
        gamePlayRanking = new TreeMap<>();
    }




    public void addPlayer(Player p){
        int rating = p.getRating();
        Set<Player> playerList = new HashSet<>();
        if(gamePlayRanking.containsKey(rating)){
            playerList = gamePlayRanking.get(rating);
            playerList.add(p);
            gamePlayRanking.put(rating, playerList);
            System.out.println("К рейтингу " + rating + " добавлен игрок " + p.getName() + " ("+ p.getId() + " )");
        }else{
            playerList.add(p);
            gamePlayRanking.put(rating, playerList);
            System.out.println("Добавлен новый игрок с рейтингом " + rating);
        }

    }

    public void updatePlayerRanking(int playerId, int newRating){
        Map<Integer, Set<Player>> playerList = new TreeMap<>(gamePlayRanking);
        Set<Player> playerSet;
        int oldRating = 0;
        int count = 0;
        circle:
        for(Map.Entry<Integer, Set<Player>> entry : playerList.entrySet()){
            for(Player p : entry.getValue()){
                if(p.getId() == playerId){
                    oldRating = p.getRating();
                    p.setRating(newRating);
                    addPlayer(p);
                    entry.getValue().remove(p);
                    count--;
                    break circle;
                }
            }
            count++;
        }
        if (count != gamePlayRanking.size()) {
            playerSet = gamePlayRanking.get(oldRating);
            playerSet.remove(playerId);
            gamePlayRanking.put(oldRating, playerSet);
        }else {System.out.println("Нет такого игрока");}


    }

    public List<Player> getTopPlayer(int n){
        List<Player> playerList = new ArrayList<>(n);
        int highestRank = gamePlayRanking.lastKey();
        while (playerList.size() < n){
            for(Player p : gamePlayRanking.get(highestRank)){
                playerList.add(p);
            }
            highestRank--;
        }
    return playerList;
    }

    public int getPlayerRank(int playerId){
        for(Map.Entry<Integer, Set<Player>> entry : gamePlayRanking.entrySet()){
            for(Player p : entry.getValue()){
                if(p.getId() == playerId){
                    return p.getRating();
                }
            }
        }
        System.out.println("Нет такого игрока");
        return 0;
    }

    public void showRanking(){
        for(Map.Entry<Integer, Set<Player>> entry : gamePlayRanking.entrySet()){

            for(Player p : entry.getValue()){
                System.out.println("Рейтинг "+ entry.getKey());
                System.out.println("Игрок " + p);
            }
        }
    }

}
