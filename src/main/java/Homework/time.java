package Homework;

import java.util.Scanner;

public class time {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество минут: ");
        int min = input.nextInt();
        System.out.println();
        System.out.println("Это равно: " + min / 60 + " часов " + min % 60 + " минут");
    }
}
