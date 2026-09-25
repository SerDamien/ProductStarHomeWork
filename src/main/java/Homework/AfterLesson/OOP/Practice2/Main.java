package Homework.AfterLesson.OOP.Practice2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(15);
        circle.setRadius(5);
        System.out.println(circle.getArea());

        TestCircle testCircle = new TestCircle();
        testCircle.conctructTestCircle();
        testCircle.setTestCircle();
        testCircle.getAreaTestCircle();
    }
}
