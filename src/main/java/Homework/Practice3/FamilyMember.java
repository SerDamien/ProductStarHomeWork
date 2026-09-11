package Homework.Practice3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class FamilyMember {
    private String name;
    private List<FamilyMember> parents;
    private List<FamilyMember> children;

    public FamilyMember(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addChild(String childName) {
        FamilyMember child = new FamilyMember(childName);
        this.children.add(child);
        child.parents.add(this);
    }

    public void addChild(FamilyMember child) {
        this.children.add(child);
        child.parents.add(this);
    }

    public void addParent(String parentName) {
        FamilyMember parent = new FamilyMember(parentName);
        this.parents.add(parent);
        parent.children.add(this);
    }

    public List<FamilyMember> findRelatives(String targetName) {
        List<FamilyMember> result = new ArrayList<>();
        Queue<FamilyMember> queue = new LinkedList<>();
        Set<FamilyMember> visited = new HashSet<>();

        queue.add(this);
        visited.add(this);

        while (!queue.isEmpty()) {
            FamilyMember current = queue.poll();

            if (current.name.equalsIgnoreCase(targetName)) {
                result.add(current);
            }

            for (FamilyMember parent : current.parents) {
                if (!visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }

            for (FamilyMember child : current.children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return result;
    }

    public void printTree() {
        printTreeHelper(0);
    }

    private void printTreeHelper(int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "└── " + this.name);
        for (FamilyMember child : children) {
            child.printTreeHelper(level + 1);
        }
    }

    public static void main(String[] args) {
        FamilyMember grandPa = new FamilyMember("Иван");

        FamilyMember father = new FamilyMember("Алексей");
        grandPa.addChild(father);

        father.addChild("Данила");
        father.addChild("Мария");
        father.addChild("Иван"); // Назовем младшего в честь дедушки!

        System.out.println("--- Генеалогическое дерево семьи ---");
        grandPa.printTree();

        System.out.println("\n--- Запускаем поиск родственника по имени 'Иван' ---");
        List<FamilyMember> maryFind = grandPa.findRelatives("Мария");
        if (!maryFind.isEmpty()) {
            FamilyMember mary = maryFind.get(0);

            List<FamilyMember> ivans = mary.findRelatives("Иван");

            System.out.println("Мария нашла родственников с именем Иван: " + ivans.size() + " чел.");
            for (FamilyMember ivan : ivans) {
                System.out.println("-> Найдена запись: " + ivan.getName());
            }
        }
    }
}
