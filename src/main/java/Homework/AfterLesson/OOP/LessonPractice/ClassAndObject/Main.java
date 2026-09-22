package Homework.AfterLesson.OOP.LessonPractice.ClassAndObject;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Street", 12, 13, TypeCar.Внедорожник);

        System.out.println("Управляем машиной " + car.getName());
        car.startEngine();
        car.turnSteeringWheel();
        car.stopEngine();

    }
}
