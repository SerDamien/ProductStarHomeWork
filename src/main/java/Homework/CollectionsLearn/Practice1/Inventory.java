package Homework.CollectionsLearn.Practice1;

import java.util.HashMap;
import java.util.Scanner;

public class Inventory {
    static HashMap<String, Integer> subjects = new HashMap<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в Инвентарь приключенца!");
        int num;
        do {
            System.out.println("Выберите действие: \n" +
            "1 - Добавить новый предмет \n" +
            "2 - Изменить количество предметов \n" +
            "3 - Удалить предмет \n" +
            "4 - Найти предмет по названию \n" +
            "5 - Показать весь инвентарь \n" +
            "6 - Выход");

            num = input.nextInt();
            switch (num) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    changeCount();
                    break;
                case 3:
                    removeSubject();
                    break;
                case 4:
                    findSubject();
                    break;
                case 5:
                    displayInventory();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Вы ввели не верный номер пункта");
            }

        }while (num != 6);

    }

    public static void addSubject() {
        System.out.println("=============================================================================");
        System.out.println("Введите наименование: ");
        String subject = input.next();
        if (subjects.containsKey(subject)) {
            System.out.println("У вас он уже есть, в количестве "+ subjects.get(subject) + ".\n Изменить количество?\n 1 - да \n 2 - нет");
            int temp = input.nextInt();
            if  (temp == 1) {
                System.out.println("Введите количество, которое надо добавить: ");
                int num = input.nextInt();
                subjects.put(subject, subjects.get(subject) + num);
            }
        }else {
            System.out.println("Введите количество");
            int num = input.nextInt();
            subjects.put(subject, num);
        }
        System.out.println("=============================================================================");
    }

    public static void changeCount() {
        System.out.println("=============================================================================");
        System.out.println("Введите наименование");
        String subject = input.next();
        System.out.println("У вас: " + subjects.get(subject));
        System.out.println("Введите количество, на которое надо изменить");
        int count =  input.nextInt();
        subjects.put(subject, count);
        System.out.println("=============================================================================");
    }

    public static void removeSubject() {
        System.out.println("=============================================================================");
        System.out.println("Введите удаляемый предмет: ");
        String subject = input.next();
        if (subjects.containsKey(subject)) {
            subjects.remove(subject);
            System.out.println("Предмет удалён");
        }
        else {
            System.out.println("Такого предмета нет");
        }
        System.out.println("=============================================================================");
    }

    public static void findSubject(){
        System.out.println("=============================================================================");
        System.out.println("Введите искомый предмет: ");
        String subject = input.next();
        if (subjects.containsKey(subject)) {
            System.out.println(subject + "\n у Вас: "+ subjects.get(subject));
        }else{
            System.out.println("Предмет не найден");
        }
        System.out.println("=============================================================================");
    }

    public static void displayInventory(){
        System.out.println("=============================================================================");
        for (String key : subjects.keySet()) {
            System.out.println(key + ": " + subjects.get(key));
        }
        System.out.println("=============================================================================");
    }
}
