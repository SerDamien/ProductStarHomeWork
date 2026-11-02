package Homework.CollectionsLearn.Workshop.StreamAndLymbda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        exc6();
    }


    public static void exc1(){
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        System.out.println(colors);

        List<String> result = colors.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }
    public static void exc2(){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int sumOfEvens = nums.stream()
                .filter(num -> num%2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumOfEvens + "");

        int sumOfOdds = nums.stream()
                .filter(num -> num%2!=0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumOfOdds + "");

    }
    public static void exc3(){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        double average = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
        System.out.println(average);
    }
    public static void exc4(){
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");

        List<String> result = colors.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void exc5(){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> result = nums.stream()
                .max(Integer::compare);
        System.out.println(result);
    }

    public static void exc6(){
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown","Red");
        System.out.println(colors);
        List<String> result = colors.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }


}


