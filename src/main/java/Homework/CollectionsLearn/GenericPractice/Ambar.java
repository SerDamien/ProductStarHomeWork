package Homework.CollectionsLearn.GenericPractice;

import java.util.ArrayList;
import java.util.List;

public class Ambar <T>{
        private List<T> animals =  new ArrayList<T>();

        public void getAnimals(List<? extends T> list){
            animals.addAll(list);
        }

        public void getCount(){
            System.out.println("Count of animals: " + animals.size());
        }
}
