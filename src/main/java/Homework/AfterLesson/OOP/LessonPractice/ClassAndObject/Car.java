package Homework.AfterLesson.OOP.LessonPractice.ClassAndObject;

public class Car {
    private String name;
    private int power;
    private int weight;
    private TypeCar type;
    private Engine engine;
    private SteeringWheel steeringWheel;

    public Car(String name, int power, int weight, TypeCar type) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.type = type;
        this.steeringWheel = new SteeringWheel();
        this.engine = new Engine();
    }

    public void startEngine() {
        engine.start();
    }
    public void stopEngine() {
        engine.stop();
    }
    public void turnSteeringWheel() {
        steeringWheel.turn();
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public TypeCar getType() {
        return type;
    }

    public Engine getEngine() {
        return engine;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }
}
