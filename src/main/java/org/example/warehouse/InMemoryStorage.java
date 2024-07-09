package org.example.warehouse;

import org.example.warehouse.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
