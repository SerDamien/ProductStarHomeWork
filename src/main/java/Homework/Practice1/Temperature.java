package Homework.Practice1;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите температуру в градусах Цельсия: ");
        int c =  input.nextInt();
        double f = c* ((double) 9 /5) +32;
        System.out.println();
        System.out.println("Температура в градусах Фаренгейта: " + f);
    }
}
