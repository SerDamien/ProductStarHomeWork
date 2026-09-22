package Homework.AfterLesson.OOP.Practice1.SmartHome;

public class SmartThermostat extends SmartDevice implements Controllable{

    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public SmartThermostat(String name, RoomType room, int temperature) {
        super(name, room);
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        String isOnStatus = "OFF";
        if (isOn = true){
            isOnStatus = "ON";
        }
        String status ="Termostat is " + isOnStatus +  ", temperature: " + this.temperature +"C, "+ "в комнате " + room;
        return status;
    }


    @Override
    public void increaseValue() {
        temperature = temperature + 1;
        System.out.println("SmartThermostat increaseValue " + temperature);
    }

    @Override
    public void decreaseValue() {
        temperature = temperature - 1;
        System.out.println("SmartThermostat decreaseValue" + temperature);
    }
}
