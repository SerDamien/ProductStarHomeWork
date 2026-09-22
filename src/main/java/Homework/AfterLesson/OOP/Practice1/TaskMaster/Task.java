package Homework.AfterLesson.OOP.Practice1.TaskMaster;

import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private Criteries criteries;
    private String assignee;
    private LocalDate startDate;
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Criteries getCriteries() {
        return criteries;
    }

    public void setCriteries(Criteries criteries) {
        this.criteries = criteries;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    protected Task(String title, String description, LocalDate dueDate, Criteries criteries) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.criteries = criteries;
        this.status = TaskStatus.TODO;

    }


}
