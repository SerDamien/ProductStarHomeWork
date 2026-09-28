package Homework.AfterLesson.OOP.Practice3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacticeWithString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        System.out.println(validationName(str));

    }

    public static boolean checkNum(String str) {
        Pattern pattern = Pattern.compile("^\\+\\d+(?:\\s|-)?+\\d{1,3}(?:\\s|-)?[0-9]{5,8}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static String removeChar(String str) {
        str = str.replaceAll("[a-zA-Z]|\\s", "");
        return str;
    }

    public static String validationName(String str) {
        Pattern errorPattern1 = Pattern.compile("^[0-9]");
        Pattern errorPattern2 = Pattern.compile("[^{3,20}]");
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{2,19}$");
        Matcher matcher = pattern.matcher(str);
        Matcher matcher1 = errorPattern1.matcher(str);
        Matcher matcher2 = errorPattern2.matcher(str);
        if (matcher.find()) {
            str = str.replaceAll("[_]+", "_");
            return str.toLowerCase();
        }else if (matcher1.find()) {
            return "Имя должно начинаться с буквы";
        }else if (matcher2.find()) {
            return "Слишком короткая строка";
        }

        return null;
    }
}
