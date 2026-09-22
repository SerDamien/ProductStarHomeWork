package Homework.AfterLesson.OOP.Practice1.TaskMaster;

public enum Criteries {
    CRITICAL(3),
    MAJOR(2),
    MINOR(1);

    private int value;
    Criteries(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
