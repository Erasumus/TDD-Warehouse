package org.example.warehouse;

import org.example.warehouse.exceptions.ItemNotFoundException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryStorage implements Storage{

    public static final int INITIAL_CAPACITY = 256;
    private final Map<String, Wheel> items = new HashMap<>(INITIAL_CAPACITY);

    @Override
    public void putItem(Wheel wheel) {
        items.put(wheel.id(), wheel);
    }

    @Override
    public Wheel getItem(String id) throws ItemNotFoundException {
        Wheel wheel = items.get(id);
        if (wheel == null) {
            throw new ItemNotFoundException(id);
        }
        return wheel;
    }

    @Override
    public boolean containsItem(String id) {
        return items.containsKey(id);
    }

    @Override
    public Wheel removeItem(String id) throws ItemNotFoundException {
        Wheel remove = items.remove(id);
        if(remove==null){
            throw new ItemNotFoundException(id);
        }
        return remove;
    }

    @Override
    public void putAllItems(List<Wheel> items) {
        for(Wheel item: items){
            putItem(item);
        }
    }

    @Override
    public Map<String, Wheel> getAllItems() {
        return new HashMap<>(items);
    }

    @Override
    public List<Wheel> getAllItemsSorted(Predicate<Wheel> predicate) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : items.values()){
            if(predicate.test(wheel)){
                list.add(wheel);
            }
        }

        list.sort(Comparator.comparing(Wheel::model)
                .thenComparing(Wheel::category)
                .thenComparing(Wheel::place)
                .thenComparing(Wheel::id));
        return list;
    }

}
