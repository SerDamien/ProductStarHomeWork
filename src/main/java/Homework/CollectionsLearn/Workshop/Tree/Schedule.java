package Homework.CollectionsLearn.Workshop.Tree;

import java.awt.print.Book;
import java.util.*;

public class Schedule {

    TreeSet<Event> scheduleSet = new TreeSet<Event>();
    TreeMap<Integer, Integer> scheduleMap = new TreeMap<>();

    void addEvent(int start, int end, String name) {
        Event event = new Event();
        event.start = start;
        event.end = end;
        event.name = name;
        scheduleSet.add(event);

        scheduleMap.put(start, scheduleMap.getOrDefault(start, 0) +1);
        scheduleMap.put(end, scheduleMap.getOrDefault(end, 0) -1);
    }

    List<Event> getLast3 (int time){
        Event o = new  Event();
        o.start = time;

        NavigableSet<Event> tailSet = scheduleSet.tailSet(o, true);
        List<Event> result = new ArrayList<Event>(3);
        for (int i = 0; i<3; i++){
            if (!tailSet.isEmpty()){
                result.add(tailSet.pollFirst());
            }
        }
        return result;
    }

    boolean hasOverLaps(){
        int cnt = 0;
        for (Integer key : scheduleMap.keySet()){
            cnt += scheduleMap.get(key);
            if (cnt>1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.addEvent(9,10,"Daily meeting");
        schedule.addEvent(11,12,"Weekly meeting");
        schedule.addEvent(15,16,"Dinner");
        schedule.addEvent(15,18,"Meeting");
        schedule.addEvent(19,20,"End Work");


        System.out.println(schedule.getLast3(9));
        System.out.println(schedule.hasOverLaps());
    }

    class Event implements Comparable<Event> {
        int start;
        int end;
        String name;
        @Override
        public int compareTo(Event o) {
            if (start == o.start) {
                return Integer.compare(end, o.end);
            } else {
                return Integer.compare(start, o.start);
            }
        }
        @Override
        public String toString() {
            return "[" +  start + " - " + end + "] " + name;
        }
    }
}
