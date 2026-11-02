package Homework.CollectionsLearn.GenericPractice;

import Homework.CollectionsLearn.GenericPractice.TypeBreeds.HotBloods;
import Homework.CollectionsLearn.GenericPractice.TypeBreeds.WarmBloods;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HorseHome<Horse> horseHome = new HorseHome<>();
        horseHome.addHorse(new HotBloods());
        horseHome.addHorse(new WarmBloods());

        List<WarmBloods> warm = Arrays.asList(new  WarmBloods(), new  WarmBloods());
        horseHome.addAllHorses(warm);

        Ambar<Animal> ambar = new Ambar<>();
        horseHome.getCount();
        moveAnimals(horseHome, ambar);
        ambar.getCount();
    }

    public static <T> void moveAnimals(HorseHome<? extends T> source, Ambar<? super T>destination){
        destination.getAnimals(source.getHorses());
    }
}
