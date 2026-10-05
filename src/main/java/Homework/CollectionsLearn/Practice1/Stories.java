package Homework.CollectionsLearn.Practice1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Stories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> characters = new ArrayList<String>();
        ArrayList<String> actions = new ArrayList<String>();
        ArrayList<String> places = new ArrayList<String>();
        ArrayList<String> storys = new ArrayList<>();

        characters.add("Гном");
        characters.add("Принцесса");
        characters.add("Робот");

        actions.add("Танцует");
        actions.add("Летает");
        actions.add("Сражается");

        places.add("В лесу");
        places.add("В городу");
        places.add("в Пустыне");

        System.out.println("Персонажей: " + characters.size() + " Действий: " + actions.size() + " Мест: " + actions.size());
        int num;
        do {
            System.out.println("«1 - Добавить персонажа»\n«2 – Добавить действие»\n«3 - Добавить место»\n«4 - Сгенерировать историю»\n«5 - Показать истории»\n«6 - Выход»");
            num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Введите персонажа: ");
                    String character = input.next();
                    characters.add(character);
                    break;
                case 2:
                    System.out.println("Введите действие: ");
                    String action = input.next();
                    actions.add(action);
                    break;
                case 3:
                    System.out.println("Введите место: ");
                    String place = input.next();
                    places.add(place);
                    break;
                case 4:
                    System.out.println("Ваша история: ");
                    generator(characters, actions, places, storys);
                    break;
                case 5:
                    for (String s : storys) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.println("Выходим...");
                    break;
                default:
                    System.out.println("Введён не верный пункт");
                    break;
            }
        } while (num != 6);
    }

    public static void generator(ArrayList<String> characters, ArrayList<String> actions, ArrayList<String> places, ArrayList<String> storys) {
        Random rand = new Random();
        storys.add(characters.get(rand.nextInt(characters.size())) + " " +  actions.get(rand.nextInt(actions.size())) + " " + places.get(rand.nextInt(places.size())));
        System.out.println(storys.get(storys.size() - 1));
    }
}
