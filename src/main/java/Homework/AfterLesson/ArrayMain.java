package Homework.AfterLesson;

public class ArrayMain {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println(array.get(12));
        array.remove(1);
        System.out.println(array.size());
    }
}
