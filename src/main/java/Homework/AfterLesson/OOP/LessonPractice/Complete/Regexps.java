package Homework.AfterLesson.OOP.LessonPractice.Complete;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexps {
    public static void main(String[] args) {
//        int count = 0;
        Scanner input = new Scanner(System.in);
        countChar(input.nextLine());
        input.close();



    }

    public static void countChar(String str) {
        int count = 0;
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        for (int i = 0; i < str.length(); i++) {
            Matcher matcher = pattern.matcher(str.substring(i, i + 1));
            if (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
