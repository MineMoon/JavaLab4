package ru.mastiko.datastructures;

import java.util.Arrays;

public class ImmutableListofValues<T> {
    private final T[] array;

    // properties
    public T[] getArray() {
        return array.clone();
    }

    // constructors
    public ImmutableListofValues(T... numbers) {
        this.array = numbers;
    }

    // copy constructor
    public ImmutableListofValues(ImmutableListofValues<T> other) {
        this.array = other.getArray();
    }

    // methods
    public T get(int index) {
        if (index < 0 || index >= this.array.length) {
            throw new RuntimeException("Index out array's bounds");
        }
        return array[index];
    }

    public ImmutableListofValues<T> set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new RuntimeException("Index out array's bounds");
        }
        T[] newArray = array.clone();
        newArray[index] = value;
        return new ImmutableListofValues<T>(newArray);
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
