package Homework.Practice2;

import java.util.Scanner;

public class TimeMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (6<=n && n <=11){
            System.out.println("Это Утро");
        }else if (12<=n && n <=17){
            System.out.println("Это День");
        }else if (18<=n && n <=21){
            System.out.println("Это Вечер");
        }else if (22<=n && n <=23 || 0<=n && n <=5){
            System.out.println("Это Ночь");
        }
    }
}
