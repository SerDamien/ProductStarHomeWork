package Homework.AfterLesson;

import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[] chars = str.toCharArray();
        int size = chars.length;

        for (int i = size-1; i >= 0; i--) {
            System.out.print((char) chars[size-1]);
            size--;
            if (size == 0) break;
        }

    }
}
