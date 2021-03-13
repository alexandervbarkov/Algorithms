package com.alexandervbarkov.algorithms.sort;

import static com.alexandervbarkov.algorithms.sort.SortUtils.swap;

public class QuickSort {
    public static void sort(int... a) {
        if (a.length < 2) return;
        sort(a, 0, a.length);
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int partition = partition(a, left, right);
        sort(a, left, partition - 1);
        sort(a, partition, right);
    }

    private static int partition(int[] a, int left, int right) {
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
