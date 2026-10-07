package Homework.CollectionsLearn.Workshop.Hash.warehouse;

import java.util.Map;
import java.util.Set;

public class CachedAnalytics implements Analytics {

    private final BasicAnalitycs basicAnalytics;

    public CachedAnalytics(BasicAnalitycs basicAnalytics){
        this.basicAnalytics = basicAnalytics;
    }

    @Override
    public Set<String> getCategories() {
        return basicAnalytics.getCategories();
    }

    @Override
    public Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace() {
        return basicAnalytics.getAggregationByCategoryAndPlace();
    }

    @Override
    public Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace) {
        return basicAnalytics.getAggregationByCategoryAndPlace(categoryAndPlace);
    }

    @Override
    public Integer getTotalCount() {
        return basicAnalytics.getTotalCount();
    }
}
