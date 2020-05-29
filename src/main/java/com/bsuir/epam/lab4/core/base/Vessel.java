package com.bsuir.epam.lab.core.base;

public abstract class Vessel {

    private final double volume;
    private Fluid content;

    public Vessel(double volume, Fluid fluid) {
        this.volume = volume;
        this.setContent(fluid);
    }

    public Vessel(double volume) {
        this(volume, null);
    }

    public double getVolume() {
        return volume;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean move(Fluid fluid) {
        if (!isEmpty() || fluid == null)
            return false;
        setContent(fluid);
        return true;
    }

    protected void setContent(Fluid fluid) {
        if (isFluidFits(content))
            this.content = fluid;
        else
            throw new IllegalArgumentException("Unable to put " + fluid.getAmount() + " of fluid to vessel with volume " + getVolume());
    }

    public Fluid getContent() {
        return content;
    }

    public boolean isFluidFits(Fluid fluid) {
        return fluid == null || fluid.getAmount() <= volume;
    }

    public abstract Fluid drain();
}
