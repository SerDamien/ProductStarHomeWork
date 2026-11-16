package Homework.multiTread.Homework.RandomNum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomNum {
    static List<Thread> threads = new ArrayList<>();
    static List<Integer> num = new ArrayList<>(100000);
    static AtomicInteger doubleNum = new AtomicInteger(0);
    static AtomicInteger tripleNum = new AtomicInteger(0);
    static AtomicInteger fourthNum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            num.add((int) (Math.random() * 9990) + 10);
        }
        threads.add(new Thread(new DoubleCounter()));
        threads.add(new Thread(new TripleCounter()));
        threads.add(new Thread(new FourthCounter()));

        for (Thread t : threads) {
            t.start();
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }
        System.out.println("двухзначных чисел " + doubleNum.get());
        System.out.println("трёхзначных чисел " + tripleNum.get());
        System.out.println("четырёхзначных чисел " + fourthNum.get());
        System.out.println(doubleNum.get() + tripleNum.get() + fourthNum.get());
    }


    public static class DoubleCounter implements Runnable {
        private int i;
        public DoubleCounter() {
            this.i = 0;
        }
        @Override
        public void run() {
            threads.add(Thread.currentThread());
            for (int i = 0; i < num.size(); i++) {
                if (10<=num.get(i) && num.get(i)<100) {
                    doubleNum.addAndGet(1);
                }
            }
        }
    }
    public static class TripleCounter implements Runnable {
        private int i;
        public TripleCounter() {
            this.i = 0;
        }
        @Override
        public void run() {
            threads.add(Thread.currentThread());
            for (int i = 0; i < num.size(); i++) {
                if (100<=num.get(i) && num.get(i)<1000) {
                    tripleNum.addAndGet(1);
                }
            }
        }
    }
    public static class FourthCounter implements Runnable {
        private int i;
        public FourthCounter() {
            this.i = 0;
        }
        @Override
        public void run() {
            threads.add(Thread.currentThread());
            for (int i = 0; i < num.size(); i++) {
                if (1000<=num.get(i)) {
                    fourthNum.addAndGet(1);
                }
            }
        }
    }



}
