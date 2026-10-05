package Homework.CollectionsLearn.Practice1;

import java.util.HashSet;
import java.util.Scanner;

public class Detective {
    static HashSet<String> clues = new HashSet<String>();
    static HashSet<String> evedance = new HashSet<String>();

    public static void main(String[] args) {
        evedance.add("zxc");
        evedance.add("zxcv");
        evedance.add("zxcvz");

        Scanner input = new Scanner(System.in);
        int num;

        System.out.println("Добро пожаловать в детективную игру");

        do{
            System.out.println("Выберите действие:\n" +
                    "1 - Добавить улику\n" +
                    "2 - Проверить наличие улики\n" +
                    "3 - Удалить улику\n" +
                    "4 - Сравнить с базой данных\n" +
                    "5 - Показать все найденные улики\n" +
                    "6 - Выход");
            num = input.nextInt();
            switch (num){
                case 1:
                    System.out.println("Введите улику: ");
                    String clue = input.next();
                    addClue(clue);
                    break;
                case 2:
                    System.out.println("Введите проверяемую улику: ");
                    String checkClue = input.next();
                    checkClue(checkClue);
                    break;
                case 3:
                    System.out.println("Введиет ложную улику");
                    String checkClue2 = input.next();
                    removeClue(checkClue2);
                    break;
                case 4:
                    System.out.println("Сравниваем...");
                    compare();
                    break;
                case 5:
                    System.out.println("Найденные улики: ");
                    getClues();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Ввели не верный номер пункта");
            }
        }while(num != 6);


    }

    public static void addClue(String clue) {
        clues.add(clue);
    }

    public static void checkClue(String clue) {
        if (clues.contains(clue)) {
            System.out.println("Улика в списке: " + clue);
        }
        else {
            System.out.println("Улика не в списке");
        }
    }

    public static void removeClue(String clue) {
        if (!clues.contains(clue)){
            System.out.println("Вы ввели улику, которой нет в списке");
        }else{
            System.out.println("Улика удалена");
            clues.remove(clue);
        }
    }

    public static void compare() {
        for (String clue : clues) {
            if (evedance.contains(clue)) {
                System.out.println(clue);
            }
        }
    }

    public static void getClues() {
        int count = 1;
        for(String clue : clues){
            System.out.println(count + ") " + clue);
            count++;
        }
    }
}
