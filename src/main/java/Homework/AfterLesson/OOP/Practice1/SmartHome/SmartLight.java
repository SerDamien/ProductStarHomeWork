package Homework.AfterLesson.OOP.Practice1.SmartHome;

public class SmartLight extends SmartDevice implements Controllable{
    private int brightness;

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public SmartLight(String name, RoomType room, int brightness) {
        super(name, room);
        this.brightness = brightness;
    }

    @Override
    public void increaseValue() {
        brightness = brightness + 1;
        System.out.println("SmartLight increaseValue");
    }

    @Override
    public void decreaseValue() {
        brightness = brightness - 1;
        System.out.println("SmartLight decreaseValue");
    }

    @Override
    public String getStatus() {
        String isOnStatus = "OFF";
        if (isOn = true){
            isOnStatus = "ON";
        }
        String status ="Light is " + isOnStatus +  ", brightness: " + this.brightness +" "+ "в комнате " + room;
        return status;
    }
}
