package org.example;

import java.util.*;

public class CustomArrayList<T> {
    private T[] array;
    private int capacity = 10;
    private int size;

    public CustomArrayList() {
        this.array = (T[]) new Object[capacity];
    }

    public CustomArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public boolean add(T t) {
        if (size < capacity) {
            size++;
            array[size] = t;
        } else {
            this.capacity = (int) (capacity * 1.5);
            this.array = Arrays.copyOf(this.array, this.capacity);
            add(size, t);
        }
        return true;
    }

    public void add(int index, T t) {
        isIndexInRange(index);
        this.array[index] = t;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
        }
        return false;
    }

    public void clear() {
        Arrays.fill(this.array, null);
    }


    public T get(int index) {
        isIndexInRange(index);
        return this.array[index];
    }

    public T set(int index, T t) {
        isIndexInRange(index);
        this.array[index] = t;
        return this.array[index];
    }

    public T remove(int index) {
        isIndexInRange(index);
        T t = this.array[index - 1];
        if (index == size) {
            this.array[size] = null;
            size--;
            return t;
        }
        for (int i = index; i < size; i++) {
            this.array[i - 1] = this.array[i];
        }
        this.array[size] = null;
        size--;
        return t;
    }

    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(this.array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    private void isIndexInRange(int index) {
        if (index < 0 || index >= this.capacity) {
            throw new IndexOutOfBoundsException("index out of range");
        }
    }
}
