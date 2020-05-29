package com.bsuir.epam.lab.core;

import com.bsuir.epam.lab.core.base.Fluid;
import com.bsuir.epam.lab.core.base.Vessel;

public class Human {

    private final String name;

    private Fluid fluid;

    public Human(String name) {
        this.name = name;
        this.fluid = null;
    }

    public String getName() {
        return name;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    public boolean hasFluid() {
        return this.fluid != null;
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

    public boolean buyFluid(Shop shop) {
        try {
            shop.serve(this);
            return true;
         } catch (IllegalStateException e) {
            return false;
        }
    }

    public boolean pourFluid(Vessel vessel) {
        if (!hasFluid())
            throw new IllegalStateException("No fluid to pour");
        vessel.move(fluid);
        return true;
    }

}
