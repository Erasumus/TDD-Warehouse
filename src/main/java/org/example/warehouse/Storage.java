package org.example.warehouse;

import org.example.warehouse.exceptions.ItemNotFoundException;

import java.util.List;

public interface Storage {
    void putItem(Wheel wheel);
    Wheel getItem(String id) throws ItemNotFoundException;
    boolean containsItem(String id);
    Wheel removeItem(String id) throws ItemNotFoundException;

    void putAllItems(List<Wheel> wheel1);
}

