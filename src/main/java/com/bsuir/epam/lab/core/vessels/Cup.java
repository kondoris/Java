package com.bsuir.epam.lab.core.vessels;

import com.bsuir.epam.lab.core.base.Fluid;
import com.bsuir.epam.lab.core.base.Vessel;
import com.bsuir.epam.lab.core.utils.Handle;

public class Cup extends Vessel {

    private Handle handle;

    public Cup(Handle handle, double volume, Fluid fluid) {
        super(volume, fluid);
        this.handle = handle;
    }

    public Cup(Handle handle, double volume) {
        super(volume);
        this.handle = handle;
    }

    public Cup(double volume, Fluid fluid) {
        super(volume, fluid);
        this.handle = null;
    }

    public Cup(double volume) {
        super(volume);
        this.handle = null;
    }

    public boolean hasHandle() {
        return handle != null;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    @Override
    public Fluid drain() {
        if (!hasHandle())
            throw new IllegalStateException("Unable to drain cup while it has no handle");
        return super.drain();
    }
}
