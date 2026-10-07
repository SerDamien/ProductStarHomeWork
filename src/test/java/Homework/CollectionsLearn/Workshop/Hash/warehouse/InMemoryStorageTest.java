package Homework.CollectionsLearn.Workshop.Hash.warehouse;

import Homework.CollectionsLearn.Workshop.Hash.warehouse.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStorageTest {

    private Storage storage;
    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
    }


    @org.junit.jupiter.api.Test
    void putAndGetItem() throws ItemNotFoundException {

        Wheel wheel = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);
        storage.putItem(wheel);
        Wheel actual = storage.getItem(wheel.id());
        assertEquals(wheel, actual);

    }

    @org.junit.jupiter.api.Test
    void getItem() throws ItemNotFoundException {
        storage.getItem("123");
        assertThrows(ItemNotFoundException.class, () -> storage.getItem("123"));
    }

    @org.junit.jupiter.api.Test
    void containsItem() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "winter", "A", 10);

        storage.putItem(wheel1);
        storage.putItem(wheel3);

        assertTrue(storage.containsItem("1"));
        assertTrue(storage.containsItem("3"));
        assertFalse(storage.containsItem("2"));

    }

    @org.junit.jupiter.api.Test
    void removeItem() throws ItemNotFoundException {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "winter", "A", 10);

        storage.putItem(wheel1);
        storage.putItem(wheel3);

        Wheel wheel = storage.removeItem("1");

        assertTrue(storage.containsItem("3"));
        assertFalse(storage.containsItem("1"));
        assertEquals(wheel, wheel1);

        assertThrows(ItemNotFoundException.class, () -> storage.removeItem("2"));
    }

    @Test
    void addListOfItem() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "winter", "A", 10);

        storage.putAllItem(List.of(wheel1, wheel2, wheel3));
        assertTrue(storage.containsItem("3"));
        assertTrue(storage.containsItem("2"));
        assertTrue(storage.containsItem("1"));
    }
    @Test
    void getAll() {
        Wheel hakka = new  Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);
        Wheel michelin =  new  Wheel(UUID.randomUUID().toString(), "michelin", "winter", "B", 10);
        Wheel hakkaSummer = new  Wheel(UUID.randomUUID().toString(), "hakkapelita", "summer", "A", 10);
        Wheel nordman =  new  Wheel(UUID.randomUUID().toString(), "nordman", "winter", "A", 10);
        Wheel noname = new  Wheel(UUID.randomUUID().toString(), "noname", "winter", "A", 10);

        storage.putAllItem(List.of(hakka, michelin, hakkaSummer, nordman, noname));
        Map<String, Wheel> allItems = storage.getAllItems();

        allItems.forEach((id, wheel) -> {
            System.out.println(id + " " + wheel);
        });

        assertEquals(5, allItems.size());
    }

    @Test
    void getAllSortedByModel() {
        Wheel hakka = new  Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);
        Wheel michelin =  new  Wheel(UUID.randomUUID().toString(), "michelin", "winter", "B", 10);
        Wheel hakkaSummer = new  Wheel(UUID.randomUUID().toString(), "hakkapelita", "summer", "A", 10);
        Wheel nordman =  new  Wheel(UUID.randomUUID().toString(), "nordman", "winter", "A", 10);
        Wheel noname = new  Wheel(UUID.randomUUID().toString(), "noname", "winter", "A", 10);
        List<Wheel> items = List.of(hakka, michelin, hakkaSummer, nordman, noname);
        storage.putAllItem(items);

        List<String> expectedModels = List.of("hakkapelita", "michelin", "noname");

        List<Wheel> allItemsSorted = storage.getAllItemsSorted(wheel -> expectedModels.contains(wheel.model()));
        List<Wheel> sortedItems = List.of(hakkaSummer, hakka, michelin, noname);
        assertEquals(4, allItemsSorted.size());
        assertEquals(sortedItems, allItemsSorted);

    }
}