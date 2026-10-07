package Homework.CollectionsLearn.Lessons;

import java.awt.print.Book;
import java.util.HashMap;

public class BookStore {

    static HashMap<String, Integer> bookStore = new HashMap<>();
    static HashMap<String, String> bookReader = new HashMap<>();

    public static void main(String[] args) {
        addBook("Voina i mir", 5);
        addBook("Master i Margarita", 5);
        addBook("Dom v kotorom", 5);


        borrowBook("Voina i mir", "Popov");
        borrowBook("Master i Margarita", "Popov");
        borrowBook("zxc", "Popov");

        showAvailableBooks();
    }

    public static void addBook(String title, Integer count){
        if(bookStore.containsKey(title)){
            bookStore.put(title, bookStore.get(title) + count);
            System.out.println("Book has been added to the store " + title);
        }else {
            bookStore.put(title, count);
            System.out.println("Book has been added to the store " + title);
        }
    }
    public static void borrowBook(String title, String reader){
        if(bookStore.containsKey(title) && (bookStore.get(title) > 0)){
            bookStore.put(title, bookStore.get(title) - 1);
            System.out.println("Book has been borrowed from the store " + title);
            bookReader.put(title, reader);
        }else {
            System.out.println("Book Not Found");
        }

    }
    public static void showAvailableBooks(){
        for(String title : bookStore.keySet()){
            System.out.println(title + " " +bookStore.get(title));
        }

    }
}
