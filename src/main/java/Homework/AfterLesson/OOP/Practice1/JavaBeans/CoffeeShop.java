package Homework.AfterLesson.OOP.Practice1.JavaBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    static List<MenuItem> menu =  new ArrayList<MenuItem>();


    public void addItemInMenu(MenuItem item){
        menu.add(item);
    }


    public static void showMenu(){
        int i = 1;
        for(MenuItem item : menu){
            System.out.println(i + " "+ item.getName() + " " + item.getPrice());
            i++;
        }
    }


    public static class Order{
        static List<MenuItem> order = new ArrayList<>();
        static double totalPrice = 0;
        public static void createOrder(){

            int choice = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("What you want to do? 0 for exit");
            showMenu();
            while(true){
                choice = sc.nextInt();
                if(choice == 0){
                    System.out.println("You order price "+totalPrice);
                    break;
                }
                order.add(menu.get(choice-1));
                System.out.println(menu.get(choice-1).getName() + menu.get(choice-1).getPrice() + " add in order ");
                totalPrice = totalPrice + menu.get(choice-1).getPrice();

                showMenu();
            };
            System.out.println("You order prepare");
            for(int i = 0; i < order.size(); i++){
                if(order.get(i) instanceof Preparable){
                    ((Preparable) order.get(i)).prepare();
                }else{
                    System.out.println("Get from table " + order.get(i).getName() +" "+ order.get(i).getPrice());
                }
            }
            CoffeeShopStats.addOrder(totalPrice);



        }

    }
    public static class CoffeeShopStats{
        private static int totalOrders = 0;
        private static double totalRevenue = 0;


        public static int getTotalOrders() {
            return totalOrders;
        }

        public static void setTotalOrders(int totalOrders) {
            CoffeeShopStats.totalOrders = totalOrders;
        }

        public static double getTotalRevenue() {
            return totalRevenue;
        }

        public static void setTotalRevenue(double totalRevenue) {
            CoffeeShopStats.totalRevenue = totalRevenue;
        }

        public static String getStats() {
            System.out.println("Total orders: " + totalOrders);
            System.out.println("Total revenue: " + totalRevenue);
            return null;
        }
        public static void addOrder(double price) {
            totalOrders++;
            totalRevenue = totalRevenue+Order.totalPrice;
        }
    }
}
