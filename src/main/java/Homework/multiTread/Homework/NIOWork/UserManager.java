package Homework.multiTread.Homework.NIOWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {

    private Path path = Path.of("user.txt");
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void loadFromFile() throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            String[] nameCity = lines.get(i).split(",");
            User user = new User(nameCity[0], nameCity[1]);
            users.add(user);
        }
    }

    public void saveToFile(User user) throws IOException {
        try{
                Files.writeString(path, user.getName() + "," + user.getCity() + "\n", StandardOpenOption.APPEND);
        }
        catch(NoSuchFileException e){
            Files.writeString(path, user.getName() + "," + user.getCity() + "\n");
            }
    }

    public void createUser(String name, String city) throws IOException {
        User user = new User(name, city);
        users.add(user);
        saveToFile(user);
    }

    public void CreateUserFromConsole() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String name = sc.nextLine();
        System.out.println("Enter user city: ");
        String city = sc.nextLine();
        createUser(name, city);
    }
    public void saveFromList() throws IOException {
        for (int i = 0; i < users.size(); i++) {
            saveToFile(users.get(i));
        }
    }
}
