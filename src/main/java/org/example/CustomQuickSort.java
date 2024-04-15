package org.example;

/**
 * The type Custom quick sort.
 *
 * @param <T> the type parameter
 */
public class CustomQuickSort<T extends Comparable<T>> {/**
 * Quick sort.
 *
 * @param list sorted list
 */
public  CustomArrayList<T> quickSort(CustomArrayList<T> list ) {
    quickSort(list, 0, list.size() - 1);
    return list;
}
    /**
     * Quick sort.
     *
     * @param list sorted list
     */
    private void quickSort(CustomArrayList<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(CustomArrayList<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if ( list.get(j).hashCode() < pivot.hashCode()) {
                i++;
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}
