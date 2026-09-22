package Homework.AfterLesson.OOP.Practice1.JavaBeans;

public class Pastry extends MenuItem{
    private String pastryType;


    public Pastry(String name, double price, String pastryType) {
        super(name, price);
        this.pastryType = pastryType;
    }
}
