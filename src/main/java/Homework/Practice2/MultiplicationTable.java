package Homework.Practice2;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число от 1 до 9: ");
        int num = sc.nextInt();
        if (num >9 || num < 1){
            System.out.println("Вы ввели не то число");
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));

        }
    }
}
