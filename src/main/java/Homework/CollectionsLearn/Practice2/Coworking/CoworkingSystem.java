package Homework.CollectionsLearn.Practice2.Coworking;

import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem {
    private final TreeSet<Workspace> workspaces = new TreeSet<>();
    private TreeMap<User, TreeSet<Workspace>> userSpaceMap = new TreeMap<>();

    public TreeMap<User, TreeSet<Workspace>> getUserSpaceMap() {
        return userSpaceMap;
    }

    public TreeSet<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void addWorkspace (Workspace workspace){
        workspaces.add(workspace);
        System.out.println(workspace + " has been added");
    }
    public void removeWorkspace (Workspace workspace){
        workspaces.remove(workspace);
        System.out.println(workspace + " has been removed");
    }
    public void registerUser(User user){
        userSpaceMap.put(user, new TreeSet<Workspace>());
        System.out.println(user.getName() + " " + user.getSurname()  + " has been registered");
    }
    public void bookWorkspace (User user, Workspace workspace){
        if (!workspace.isAvailable()){
            System.out.println("Workspace is not available");
        }
        else {
            workspace.markAsBooked();
            userSpaceMap.get(user).add(workspace);
            System.out.println(user.getName() + " " + user.getSurname()  + " забронировал");
        }
    }
    public void cancelWorkspace (User user, Workspace workspace){
        if (!workspace.isAvailable()){
            userSpaceMap.get(user).remove(workspace);
            workspace.markAsAvailable();
            System.out.println(user.getName() + " " + user.getSurname()  + " отменил бронь");

        }else{
            System.out.printf("%s не забронировано", workspace.getType());

        }
    }

    public int showAvailableWorkspaces(){
        int count = workspaces.size();
        for (Workspace workspace : workspaces){
            if (workspace.isAvailable()){
                System.out.println(workspace.getType() + " "+ workspace.getNumSpace() + " Доступна для брони");
                count++;
            }
            count--;
            if (count == 0){
                System.out.println("Нет доступных мест");
            }
        }
        return count;
    }
}
