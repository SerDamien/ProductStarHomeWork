package Homework.AfterLesson.OOP.Practice1.SmartHome;

public class SmartTV extends SmartDevice implements Controllable{

    private int canal;

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public SmartTV(String name, RoomType room, int canal) {
        super(name, room);
        this.canal = canal;
    }

    @Override
    public String getStatus() {
        String isOnStatus = "OFF";
        if (isOn = true){
            isOnStatus = "ON";
        }
        String status ="TV is " + isOnStatus +  ", canal: " + this.canal +" "+ "в комнате " + room;
        return status;
    }

    @Override
    public void increaseValue() {
        System.out.println("SmartTV increaseValue");
    }

    @Override
    public void decreaseValue() {
        System.out.println("SmartTV decreaseValue");
    }
}
