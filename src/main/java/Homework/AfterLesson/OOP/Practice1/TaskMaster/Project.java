package Homework.AfterLesson.OOP.Practice1.TaskMaster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project implements Manageable{
    private String name;

    public String getName() {
        return name;
    }

    public Project(String name) {
        this.name = name;
    }

    List<Task> tasksInProject = new ArrayList<>();

    @Override
    public void createTask(String title, String description, LocalDate dueDate, Criteries criteries) {
        Task task = new Task(title, description, dueDate, criteries);
        tasksInProject.add(task);
    }

    @Override
    public void assign(Task task, String assignee) {
        task.setAssignee(assignee);
        System.out.println("Task assigned to " + assignee);
    }

    @Override
    public void start(Task task, LocalDate start) {
        task.setStatus(TaskStatus.IN_PROGRESS);
        task.setStartDate(start);
        System.out.println("Task started");
    }

    @Override
    public void complete(Task task, LocalDate end) {
        task.setStatus(TaskStatus.DONE);
        task.setEndDate(end);
        System.out.println("Task completed");
    }

    public static class TaskComparator implements Comparator {
        private String criteria;

        public TaskComparator(String criteria) {
            this.criteria = criteria;
        }

        public static void compare(Project project) {
            if (project != null && project.tasksInProject != null && project.tasksInProject.size() > 1) {
                int n = project.tasksInProject.size();
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (project.tasksInProject.get(j).getCriteries().getValue() > project.tasksInProject.get(j + 1).getCriteries().getValue()) {
                            Collections.swap(project.tasksInProject, j, j + 1);

                        }
                    }
                }
            }
        }



    }
    public static class ProjectStats {

        public static void countOpentask(Project project) {
            int count = 0;
            for (Task task : project.tasksInProject) {
                if (task.getStatus() == TaskStatus.IN_PROGRESS || task.getStatus() == TaskStatus.TODO) {
                    count++;
                }
            }
            System.out.println("Open Task in project "+ project.getName() + " - " + count  );
        }
    }
}
