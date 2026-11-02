package Homework.WorkWithFile.Practice1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainIn {
    public static void main(String[] args) {
        List<Trip> restoredTrips;
        List<Trip> trips;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trip.ser"))) {
            restoredTrips = (List<Trip>) ois.readObject();
            System.out.println("Успешно прочитано объектов: " + restoredTrips.size() );
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new ObjectMapper();
        try{
            trips = mapper.readValue(new File("trip.json"), new TypeReference<List<Trip>>() {});
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(trips.size());
    }
}

