package com.bsuir.epam.lab.core.vessels;

import com.bsuir.epam.lab.core.base.Fluid;
import com.bsuir.epam.lab.core.base.Vessel;

public class Teapot extends Vessel {

    public Teapot(double volume, Fluid fluid) {
        super(volume, fluid);
    }

    public Teapot(double volume) {
        super(volume);
    }

    @Override
    public Fluid drain() {
        Fluid f = getContent();
        this.setContent(null);
        return f;
    }
}
