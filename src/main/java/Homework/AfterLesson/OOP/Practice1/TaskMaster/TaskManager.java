package Homework.AfterLesson.OOP.Practice1.TaskMaster;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Project> projects;

    public TaskManager() {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void displayAllProjects() {
        System.out.println("==========All Projects================");
        for (Project project : projects) {
            System.out.println(project.getName());
        }
        System.out.println("====================================");
    }

    public void displayAllTaskInProject(Project project) {
        System.out.println("==========Task in Project================");
        System.out.println(project.getName());
        for (Task task : project.tasksInProject) {

            System.out.println(" Title: "+task.getTitle() + ", Description: " + task.getDescription() + " Status: " + task.getStatus() + ", DueDate: " + task.getDueDate() + ", Criteries: " + task.getCriteries());
        }
        System.out.println("=========================================");
    }


}
