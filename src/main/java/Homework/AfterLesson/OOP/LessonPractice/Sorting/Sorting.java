package Homework.AfterLesson.OOP.LessonPractice.Sorting;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        long startTimeas = System.nanoTime();
        Arrays.sort(arr);
        long endTimeas = System.nanoTime();
        System.out.println("Array.sort: " + (startTimeas - endTimeas) + " ns");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        long startTimebs = System.nanoTime();
        bubbleSort(arr);
        long endTimebs = System.nanoTime();
        System.out.println("bubbleSort: " + (startTimebs - endTimebs) + " ns");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        long startTimeis = System.nanoTime();
        insertionSort(arr);
        long endTimeis = System.nanoTime();
        System.out.println("insertionSort: " + (startTimeis - endTimeis) + " ns");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
