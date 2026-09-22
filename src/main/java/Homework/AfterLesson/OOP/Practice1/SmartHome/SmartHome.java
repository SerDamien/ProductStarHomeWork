package Homework.AfterLesson.OOP.Practice1.SmartHome;

public class SmartHome {

    public static void main(String[] args) {
        SmartLight smartLight = new SmartLight("Light", RoomType.ГОСТИННАЯ, 15);
        HomeStats.incrementActiveDevices();
        HomeStats.incrementTotalDevices();
        SmartThermostat smartThermostat = new SmartThermostat("Thermostat", RoomType.ГОСТИННАЯ, 18);
        HomeStats.incrementActiveDevices();
        HomeStats.incrementTotalDevices();
        SmartTV smartTV = new SmartTV("TV", RoomType.ГОСТИННАЯ, 3);
        HomeStats.incrementActiveDevices();
        HomeStats.incrementTotalDevices();

        smartLight.isOn = true;
        smartThermostat.isOn = false;
        HomeStats.decreaseActiveDevices();
        smartTV.isOn = true;


        System.out.println(smartLight.getStatus());
        System.out.println(smartThermostat.getStatus());
        System.out.println(HomeStats.getActiveDevices());
        System.out.println(HomeStats.getTotalDevices());


    }






    public static class HomeStats {
        private static int totalDevices = 0;
        private static int activeDevices = 0;

        public static void incrementTotalDevices() {
            totalDevices++;
        }
        public static void incrementActiveDevices() {
            activeDevices++;
        }
        public static void decreaseTotalDevices() {
            totalDevices--;
        }
        public static void decreaseActiveDevices() {
            activeDevices--;
        }
        public static int getTotalDevices() {
            return totalDevices;
        }
        public static int getActiveDevices() {
            return activeDevices;
        }
    }
}


