package Homework.AfterLesson;

public class SearchElementInArray {
    public static void main(String[] args) {
        int n = 3232;
        int[] arr = new int[] {1, 23, 21, 2323,-123, 32, 65, 0, -5};
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                found = true;
                System.out.println("Найдено!");
                break;
            }
        }
        if (!found) {
            System.out.println("Не найдено!");
        }
    }
}
