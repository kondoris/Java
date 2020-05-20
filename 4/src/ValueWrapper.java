public class ValueWrapper<T> {

    interface IApplicable<T> {
        T apply(T value);
    }

    private T value;

    public ValueWrapper(T initial) {
        this.value = initial;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void apply(IApplicable<T> applicable) {
        setValue(applicable.apply(getValue()));
    }
}
