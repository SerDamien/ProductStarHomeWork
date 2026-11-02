package Homework.WorkWithFile.Practice1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Trip> weakTripList = new ArrayList<>();
    private static final List<Trip> trips = new ArrayList<>();

    public static void main(String[] args) {
    long count = 0L;
    while(count < 10) {
        DestinationDot dest = new DestinationDot("asd");
        Trip trip = new Trip("asd");
        trip.setDestination(dest);
        trips.add(trip);
        count++;
        }
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trip.ser"))) {
        oos.writeObject(trips);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    Runtime runtime = Runtime.getRuntime();
    long usedMemory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println("Используемая память: " + usedMemory / 1024 + " KB");

    long count2 = 0L;
    System.gc();
    while(count2 < 10) {
        DestinationDot dest2 = new DestinationDot("asd");
        Trip trip = new Trip("asd");
        trip.setDestination(dest2);
        weakTripList.add(new WeakReference<>(trip).get());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trip2.ser"))) {
            oos.writeObject(trips);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        count2++;
    }

    //Сериализуем через Json
    ObjectMapper mapper = new ObjectMapper();
    try {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("trip.json"), trips);
        System.out.println("file serialized");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.gc();
    Runtime runtime2 = Runtime.getRuntime();
    long usedMemory2 = runtime2.totalMemory() - runtime.freeMemory();
    System.out.println("Используемая память: " + usedMemory2 / 1024 + " KB");

    }


}
