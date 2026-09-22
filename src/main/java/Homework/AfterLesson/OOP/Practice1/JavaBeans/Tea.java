package Homework.AfterLesson.OOP.Practice1.JavaBeans;

public class Tea extends MenuItem implements Preparable {
    private String teaType;
    private final Size size;

    public Tea(String name, double price, String teaType, Size size) {
        super(name, price);
        this.teaType = teaType;
        this.size = size;
    }


    @Override
    public void prepare() {
        System.out.println("Preparing tea" + name + " " + teaType +" "+ size + " Size " + price);
    }
}
