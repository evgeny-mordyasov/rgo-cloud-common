package rgo.cloud.common.spring.storage;

@FunctionalInterface
public interface TxSupplier<T> {

    T get() throws Throwable;
}
