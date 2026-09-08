package Homework.Practice2;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int WishNum = rand.nextInt(100)+1;
        int attempts = 0;
        int num;
        do{
            System.out.print("Введите угадываемое число: ");
            num = sc.nextInt();
            if (WishNum != num){
                attempts++;
                System.out.println("Вы ошиблись, количество пройденных попыток: " + attempts);
                if (num > WishNum){
                    System.out.println("Высоко взяли, надо меньше");
                }else if (num < WishNum){
                    System.out.println("Низковато, можно и побольше");
                }
            }else if  (WishNum == num){
                System.out.println("Вы угадали");
                break;
            }
        }
        while (num != WishNum);
    }
}
