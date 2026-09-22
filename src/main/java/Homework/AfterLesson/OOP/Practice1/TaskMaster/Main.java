package Homework.AfterLesson.OOP.Practice1.TaskMaster;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Project project1 = new Project("DFA");
        Project project2 = new Project("VTB");
        Project project3 = new Project("ALFA");
        TaskManager manager = new TaskManager();
        manager.addProject(project1);
        manager.addProject(project2);
        manager.addProject(project3);

        project1.createTask("Load Testing", "Start load testing", LocalDate.of(2026,9,3),Criteries.CRITICAL);
        project1.createTask("Manual Testing", "Start manual testing", LocalDate.of(2026,9,4), Criteries.MAJOR);
        project1.createTask("Load Testing2", "Start load testing", LocalDate.of(2026,9,3),Criteries.CRITICAL);
        project1.createTask("Load Testing3", "Start load testing", LocalDate.of(2026,9,3),Criteries.MINOR);
        project1.createTask("Manual Testing2", "Start manual testing", LocalDate.of(2026,9,4), Criteries.MAJOR);
        project1.createTask("Load Testing4", "Start load testing", LocalDate.of(2026,9,3),Criteries.CRITICAL);


        project1.assign(project1.tasksInProject.get(0), "Popov Sergey");
        project1.assign(project1.tasksInProject.get(1), "Popov Sergey");

        project1.start(project1.tasksInProject.get(0), LocalDate.of(2026,9,3));
        project1.complete(project1.tasksInProject.get(1), LocalDate.of(2026,9,4));

        manager.displayAllProjects();
        manager.displayAllTaskInProject(project1);
        Project.TaskComparator.compare(project1);

        manager.displayAllTaskInProject(project1);

        Project.ProjectStats.countOpentask(project1);

    }
}
