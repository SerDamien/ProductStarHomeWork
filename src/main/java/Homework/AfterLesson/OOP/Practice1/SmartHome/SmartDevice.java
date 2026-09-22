package Homework.AfterLesson.OOP.Practice1.SmartHome;

public abstract class SmartDevice {
    protected String name;
    protected boolean isOn;
    protected RoomType room;

    public SmartDevice(String name, RoomType room) {
        this.name = name;
        this.room = room;
    }

    public final void turnOn(){
        isOn = true;
        System.out.println("Включено");
    }
    public final void turnOff(){
        isOn = false;
        System.out.println("Выключено");
    }

    public abstract String getStatus();
}
