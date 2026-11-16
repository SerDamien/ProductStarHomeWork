package Homework.multiTread.Homework.Cafe;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Cafe {
    static ArrayList<String> menu;
    static List<String> dishes = new ArrayList<>(List.of("Борщ", "Солянка", "Окрошка", "Уха"));
    private static final Semaphore SEMAPHORE = new Semaphore(0);


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Chief()).start();
        for (int i = 0; i < 3; i++) {
            new Thread(new Customer(i)).start();
            Thread.sleep(6000);
        }
    }

    public static class Chief implements Runnable {
        private int i;
        public Chief() {
            this.i = (int) (Math.random()*4) + 1;
        }
        @Override
        public void run() {
            int count = 0;
            menu = new ArrayList<>();
            while (count<11) {
                try {
                    Thread.sleep(1000);
                    String dish = dishes.get((int) (Math.random()*dishes.size()));
                    menu.add(dish);
                    System.out.println("в меню добавлено " + dish);
                    SEMAPHORE.release(1);
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Customer implements Runnable {
        private int customerNumber;
        public Customer(int  customerNumber) {
            this.customerNumber = customerNumber;
        }
        @Override
        public void run() {
            System.out.println("Пришел покупатель " + customerNumber);
            try {
                if(SEMAPHORE.availablePermits() == 0) {
                    System.out.printf("Блюда нет, покупатель %d ждёт\n", customerNumber);
                }
                SEMAPHORE.acquire();
                synchronized (menu) {

                    for (int i = 0; i < menu.size(); i++) {
                        if (menu.get(i)!=null) {
                            String dish = menu.get(i);
                            menu.set(i, null);
                            System.out.printf("Покупатель %d взял блюдо %s\n", customerNumber,  dish);
                            break;
                        }
                    }
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
