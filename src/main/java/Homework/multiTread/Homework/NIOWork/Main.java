package Homework.multiTread.Homework.NIOWork;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();

//        userManager.CreateUserFromConsole();
//        userManager.createUser("asd1", "asddd");
//        userManager.createUser("asd2", "asddd");
//        userManager.createUser("asd3", "asddd");
//        userManager.createUser("asd4", "asddd");
//        userManager.createUser("asd5", "asddd");


        System.out.println(userManager.getUsers().toString());

        userManager.loadFromFile();
        userManager.saveFromList();

        System.out.println(userManager.getUsers().toString());
    }
}
