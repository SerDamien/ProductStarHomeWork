package Homework.AfterLesson.OOP.Practice1.JavaBeans;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        CoffeeShop coffeeShop = new CoffeeShop();

        Coffee latte = new Coffee("Latte", "STRONG", 100, Size.LARGE);
        Coffee cappuchino = new Coffee("Cappuchino", "MEDIUM", 200, Size.MEDIUM);
        Tea blackTea = new Tea("Black Tea", 100 , "Black" , Size.LARGE);
        Pastry donut = new Pastry("Donut", 150, "Donut");

        coffeeShop.addItemInMenu(cappuchino);
        coffeeShop.addItemInMenu(latte);
        coffeeShop.addItemInMenu(latte);
        coffeeShop.addItemInMenu(donut);
        coffeeShop.addItemInMenu(blackTea);

        System.out.println("Welcome to CoffeeShop!");
        System.out.println("Choose an option:");
        System.out.println("1. Show menu");
        System.out.println("2. Add Order");
        System.out.println("3. Check Statistics");
        do {
            choice = input.nextInt();
            switch (choice) {
                 case 1: coffeeShop.showMenu();
                 break;
                 case 2: CoffeeShop.Order.createOrder();
                 break;
                 case 3: CoffeeShop.CoffeeShopStats.getStats();
                 break;
                 case 0:
                     System.out.println("Thanks for choice");
                     System.exit(0);
                default:
                    System.out.println("Invalid choice");
             }
        }while (choice != 0);


    }
}
