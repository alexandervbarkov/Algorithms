package com.alexandervbarkov.algorithms.sort;

import static com.alexandervbarkov.algorithms.sort.SortUtils.swap;

public class QuickSort {
    public static int[] sort(int... a) {
        if (a.length < 2) return a;
        sort(a, 0, a.length);
        return a;
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int partition = partition(a, left, right);
        sort(a, left, partition - 1);
        sort(a, partition, right);
    }

    private static int partition(int[] a, int left, int right) {
        //15, 3, 2, 1, 9, 5, 9, 7, 8, 6
        int pivot = a[right - 1];
        int partition = left;
        for (int i = left; i < right; i++) {
            if(a[i] <= pivot) {
                swap(a, partition, i);
                ++partition;
            }
        }
        return partition;
    }
}
