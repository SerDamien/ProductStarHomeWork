package Homework.Practice1;

import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите длину прямоугольника: ");
        double length = input.nextDouble();
        System.out.println("");
        System.out.print("Введите ширину прямоугольника: ");
        double width = input.nextDouble();
        double area = length * width;
        System.out.println("");
        System.out.println("Площадь прямоугольника: " + area);
    }
}
