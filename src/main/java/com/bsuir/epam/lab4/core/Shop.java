package com.bsuir.epam.lab.core;

import com.bsuir.epam.lab.core.base.Fluid;

import java.util.ArrayList;

public class Shop {

    private final ArrayList<Fluid> store = new ArrayList<>();

    public Shop() { }

    public void addProduct(Fluid f) {
        store.add(f);
    }

    private Fluid transferFluid() {
        if (store.isEmpty())
            throw new IllegalStateException("Store has no fluids anymore");
        Fluid f = store.get(store.size() - 1);
        store.remove(store.size() - 1);
        return f;
    }

    public void serve(Human human) {
        if (!human.hasFluid()) {
            human.setFluid(transferFluid());
        }
    }

}
