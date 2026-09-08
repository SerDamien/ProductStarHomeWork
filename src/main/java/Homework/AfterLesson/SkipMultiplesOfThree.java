package Homework.AfterLesson;

import java.util.Scanner;


public class SkipMultiplesOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0){
                continue;
            }else{
                System.out.println(i);
            }
        }
    }
}