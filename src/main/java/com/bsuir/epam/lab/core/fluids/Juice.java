package com.bsuir.epam.lab.core.fluids;

import com.bsuir.epam.lab.core.base.Fluid;

public class Juice extends Fluid {

    private final String taste;

    public Juice(String taste, double amount) {
        super(amount);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }
}
