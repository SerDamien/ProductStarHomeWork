package Homework.CollectionsLearn.Workshop.Hash.warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BasicAnalitycsTest {

    private Analytics analytics;
    private Storage storage;
    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
        analytics = new BasicAnalitycs(storage);
    }

    @Test
    void getCategories() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel whinter =  new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel whinter2 =  new Wheel("3", "hakkapelita", "winter", "A", 5);
        Wheel whinter3 =  new Wheel("4", "hakkapelita", "winter", "A", 5);
        Wheel allSeasons = new Wheel("5", "hakkapelita", "allseasons", "A", 5);
        storage.putAllItem(List.of(wheel, whinter, whinter2, whinter3, allSeasons));

        Set<String> categories = analytics.getCategories();
        assertEquals(3, categories.size());
        assertTrue(categories.contains("winter"));
        assertTrue(categories.contains("allseasons"));
        assertTrue(categories.contains("summer"));
    }

    @Test
    void getAggregationByCategoryAndPlace() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel whinter =  new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel whinter2 =  new Wheel("3", "hakkapelita", "winter", "A", 5);
        Wheel whinter3 =  new Wheel("4", "hakkapelita", "winter", "B", 5);
        Wheel allSeasons = new Wheel("5", "hakkapelita", "allseasons", "A", 5);
        storage.putAllItem(List.of(wheel, whinter, whinter2, whinter3, allSeasons));

        Map<CategoryAndPlace, Integer> aggregationByCategoryAndPlace = analytics.getAggregationByCategoryAndPlace();
        System.out.println(aggregationByCategoryAndPlace);
//        assertEquals(10, aggregationByCategoryAndPlace);

    }

    @Test
    void getAggregationByCategoryAndPlaceSingleRequest() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel whinter =  new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel whinter2 =  new Wheel("3", "hakkapelita", "winter", "A", 5);
        Wheel whinter3 =  new Wheel("4", "hakkapelita", "winter", "B", 5);
        Wheel allSeasons = new Wheel("5", "hakkapelita", "allseasons", "A", 5);
        storage.putAllItem(List.of(wheel, whinter, whinter2, whinter3, allSeasons));

        Integer quantity = analytics.getAggregationByCategoryAndPlace(new CategoryAndPlace("winter", "A"));

        assertEquals(10, quantity);

    }

    @Test
    void getTotalCount() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel whinter =  new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel whinter2 =  new Wheel("3", "hakkapelita", "winter", "A", 5);
        Wheel whinter3 =  new Wheel("4", "hakkapelita", "winter", "A", 5);
        Wheel allSeasons = new Wheel("5", "hakkapelita", "allseasons", "A", 5);
        storage.putAllItem(List.of(wheel, whinter, whinter2, whinter3, allSeasons));

        assertEquals(25, analytics.getTotalCount());
    }
}