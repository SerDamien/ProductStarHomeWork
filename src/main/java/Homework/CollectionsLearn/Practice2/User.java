package Homework.CollectionsLearn.Practice2;

import java.util.TreeSet;
import java.util.UUID;

public class User implements Comparable<User>{
    private String name;
    private String surname;
    private UUID id;
    private TreeSet<Workspace>  workspaces;

    public User (String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TreeSet<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(TreeSet<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    @Override
    public int compareTo(User o) {
        String name1 = this.name;
        String name2 = o.getName();
        return name1.compareTo(name2);
    }
}
