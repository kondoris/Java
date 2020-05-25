package com.bsuir.epam.lab.core;

import com.bsuir.epam.lab.core.base.Vessel;

public class Human {

    private final String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveFluid(Vessel from, Vessel to) {
        if (from.isEmpty()) {
            throw new IllegalArgumentException("First container is empty.");
        }
        if (!to.isEmpty()) {
            throw new IllegalArgumentException("Second container isn't empty");
        }
        to.move(from.drain());
    }

    public boolean drink(Vessel from) {
        if (from.isEmpty())
            return false;
        from.drain();
        return true;
    }
}
