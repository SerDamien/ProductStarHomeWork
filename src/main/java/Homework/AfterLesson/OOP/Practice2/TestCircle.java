package Homework.AfterLesson.OOP.Practice2;

public class TestCircle {
    public void conctructTestCircle() {
        Circle circle = new Circle(15);
        try{
        Circle circle2 = new Circle(-15);
        }catch(Exception e){
            System.out.println("test Success");
        }

    }
    public void setTestCircle() {
        Circle circle = new Circle(15);
        circle.setRadius(5);
        try{
            Circle circle2 = new Circle(-15);
        }catch(Exception e){
            System.out.println("test Success");
        }

    }
    public void getAreaTestCircle() {
        Circle circle = new Circle(15);
        System.out.println(circle.getArea());

    }
}
