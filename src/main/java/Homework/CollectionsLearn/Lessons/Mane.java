package Homework.CollectionsLearn.Lessons;

import java.util.HashMap;

public class Mane {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        switchPlace(map, map2);
        System.out.println(map2);
    }

    public static void switchPlace(HashMap<Integer, String> map, HashMap<String, Integer> map2) {
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
    }
}
