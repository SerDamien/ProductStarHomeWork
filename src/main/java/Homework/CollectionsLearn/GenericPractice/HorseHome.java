package Homework.CollectionsLearn.GenericPractice;

import java.util.ArrayList;
import java.util.List;

public class HorseHome<T> {
    private final List<T> horses = new ArrayList<>();

    public List<T> getHorses() {
        return horses;
    }

    public T addHorse(T t) {
        horses.add(t);
        System.out.println("Added horse " + t);
        return t;
    }

    public void addAllHorses(List<? extends T> t) {
        horses.addAll(t);
    }

    public void getCount(){
        System.out.println("Count of horses: " + horses.size());
    }
}
