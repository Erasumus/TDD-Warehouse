package org.example.warehouse;

import java.util.Map;
import java.util.Set;

public interface Analytics {
    Set<String> getCategories();

    Set<String> getItems();

    Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace();

    Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace);

    Integer getTotalCount();

}
