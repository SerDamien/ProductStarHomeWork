package Homework.CollectionsLearn.Workshop.Hash.warehouse;

import Homework.CollectionsLearn.Workshop.Hash.warehouse.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CachedAnalyticsTest {

    private final Storage storage = new Storage() {
        private int calls = 0;
        @Override
        public void putItem(Wheel wheel) {

        }

        @Override
        public Wheel getItem(String id) throws ItemNotFoundException {
            return null;
        }

        @Override
        public boolean containsItem(String id) {
            return false;
        }

        @Override
        public Wheel removeItem(String id) throws ItemNotFoundException {
            return null;
        }

        @Override
        public void putAllItem(List<Wheel> items) {

        }

        @Override
        public Map<String, Wheel> getAllItems() {
            calls++;
            Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
            Wheel whinter =  new Wheel("2", "hakkapelita", "winter", "A", 5);
            Wheel whinter2 =  new Wheel("3", "hakkapelita", "winter", "A", 5);
            Wheel whinter3 =  new Wheel("4", "hakkapelita", "winter", "B", 5);
            Wheel allSeasons = new Wheel("5", "hakkapelita", "allseasons", "A", 5);
            return Map.of(wheel.id(), wheel, whinter.id(), whinter, whinter2.id(), whinter2, whinter3.id(),whinter3, allSeasons.id(), allSeasons);

        }

        @Override
        public List<Wheel> getAllItemsSorted(Predicate<Wheel> predicate) {
            return List.of();
        }
    };
    private final Analytics analytics = new CachedAnalytics(new BasicAnalitycs(storage));

    @Test
    void callOnceForRepeatRequests() {
        CategoryAndPlace request = new CategoryAndPlace("winter", "A");
        Integer aggregationByCategoryAndPlace = analytics.getAggregationByCategoryAndPlace(request);
        assertEquals(10, aggregationByCategoryAndPlace);
    }

}