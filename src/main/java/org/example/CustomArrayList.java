package org.example;

import java.util.*;

/**
 * The type Custom array list.
 *
 * @param <T> the type parameter
 */
public class CustomArrayList<T> {
    private T[] array;
    private int capacity = 10;
    private int size;

    /**
     * Instantiates a new Custom array list.
     */
    public CustomArrayList() {
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Instantiates a new Custom array list.
     *
     * @param capacity - capacity of CustomArrayList
     */
    public CustomArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        }
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Size int.
     *
     * @return size of CustomArrayList
     */
    public int size() {
        return this.size;
    }

    /**
     * Is empty boolean.
     *
     * @return is CustomArrayList empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Contains boolean.
     *
     * @param o searched element
     * @return is CustomArrayList contains o
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Add boolean.
     *
     * @param t element to be added
     * @return return true if element added
     */
    public boolean add(T t) {
        if (size < capacity) {
            array[size] = t;
        } else {
            this.capacity = (int) (capacity * 1.5);
            this.array = Arrays.copyOf(this.array, this.capacity);
            add(size, t);
        }
        size++;
        return true;
    }

    /**
     * Add.
     *
     * @param index index to which we add the element
     * @param t     element to be added
     */
    public void add(int index, T t) {
        isIndexInRange(index);
        this.array[index] = t;
    }

    /**
     * Remove boolean.
     *
     * @param o element to be removed
     * @return is element removed
     */
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Clear.
     */
    public void clear() {
        this.capacity = 10;
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }


    /**
     * Get t.
     *
     * @param index index of searched element
     * @return searched element
     */
    public T get(int index) {
        isIndexInRange(index);
        return this.array[index];
    }

    /**
     * Set t.
     *
     * @param index index of searched element
     * @param t     new value
     */
    public void set(int index, T t) {
        isIndexInRange(index);
        this.array[index] = t;
    }

    /**
     * Remove t.
     *
     * @param index index of element to be removed
     * @return removed element
     */
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

    /**
     * Index of int.
     *
     * @param o searched element
     * @return index of searched element
     */
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

    /**
     * isIndexInRange.
     *
     * @param index checked index
     *  is index in range of array
     */

    private void isIndexInRange(int index) {
        if (index < 0 || index >= this.capacity) {
            throw new IndexOutOfBoundsException("index out of range");
        }
    }

    /**
     * Sort.
     *
     * @param comparator the comparator used in comparison
     */
    public  void  sort(Comparator<T> comparator){
        Arrays.sort( this.array, 0, size, comparator);
    }
}
