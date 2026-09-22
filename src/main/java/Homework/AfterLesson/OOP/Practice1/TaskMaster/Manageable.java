package Homework.AfterLesson.OOP.Practice1.TaskMaster;

import java.time.LocalDate;
import java.util.List;

public interface Manageable {
    public void createTask(String title, String description, LocalDate dueDate, Criteries criteries);
    public void assign(Task task, String assignee);
    public void start(Task task, LocalDate start);
    public void complete(Task task, LocalDate end);
}
