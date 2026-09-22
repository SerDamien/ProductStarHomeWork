package Homework.AfterLesson.OOP.Practice1.JavaBeans;

public class Coffee extends MenuItem implements Preparable {
    private final Size size;
    private String strenght;

    public Coffee(String name, String strenght, double price, Size size) {
        super(name, price);
        this.strenght = strenght;
        this.price = price;
        this.size = size;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Coffee " + name + " " + strenght + " " + size + " Size " + price);
    }
}
