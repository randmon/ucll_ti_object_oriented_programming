package domain.interfaces;

public interface HasNotNullParameters {
    default void checkNotNull(Object o) {
        if (o == null) throw new IllegalArgumentException();
    }
}
