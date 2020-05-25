package com.bsuir.epam.lab.core.vessels;

import com.bsuir.epam.lab.core.base.Fluid;
import com.bsuir.epam.lab.core.base.Vessel;
import com.bsuir.epam.lab.core.utils.Cap;

public class Bottle extends Vessel {

    private Cap cap;

    public Bottle(Cap cap, double volume, Fluid fluid) {
        super(volume, fluid);
        this.cap = cap;
    }

    public Bottle(Cap cap, double volume) {
        super(volume);
        this.cap = cap;
    }

    public Bottle(double volume, Fluid fluid) {
        super(volume, fluid);
        this.cap = null;
    }

    public Bottle(double volume) {
        super(volume);
        this.cap = null;
    }

    public boolean hasCap() {
        return cap != null;
    }

    public Cap getCap() {
        return cap;
    }

    public void setCap(Cap cap) {
        this.cap = cap;
    }

    @Override
    public Fluid drain() {
        if (hasCap())
            throw new IllegalStateException("Unable to drain bottle while it has cap");
        return super.drain();
    }

    @Override
    public boolean move(Fluid fluid) {
        if (hasCap())
            throw new IllegalStateException("Unable to move fluid into bottle while it has cap");
        return super.move(fluid);
    }
}
