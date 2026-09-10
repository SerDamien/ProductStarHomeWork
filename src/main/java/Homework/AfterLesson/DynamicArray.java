package Homework.AfterLesson;


import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;

    public DynamicArray() {
        array = new int[2];  // Начальная емкость 2
        size = 0;
    }

    public void add(int element) {
        if (size == array.length) {
            // Создаем новый массив с удвоенной емкостью
            int[] newArray = new int[array.length * 2];
            // Копируем элементы из старого массива
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        }
        // Сдвигаем все элементы влево
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;  // Очищаем последний элемент
        size--;
    }

    public int size() {
        return size;
    }
}


