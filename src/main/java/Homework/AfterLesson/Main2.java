package Homework.AfterLesson;


public class Main2 {
    static int[] data = {4, 3, 1, 5}; // Заранее заданный массив

    public static void main(String[] args) {
        print(); // Должно вывести: [4, 3, 1, 5]
        sort();
        print(); // Должно вывести: [1, 3, 4, 5]
    }

    static void sort() {
        int size = data.length;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (data[i] < data[j]) {
                    temp[j] = data[i];
                    data[i] = data[j];
                    data[j] = temp[j];

                }
            }
        }
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }
}
