package com.alexandervbarkov.algorithms.sort

import java.util.function.Consumer

class SortTestUtils {
    def static RANDOM_NUMBER_GENERATOR = new Random()
    def static MAX_ARRAY_ELEMENT_VALUE = 100
    def static MAX_ARRAY_SIZE = 1000

    static void testSort(
            Consumer<int[]> sort,
            int maxArrayElementValue = MAX_ARRAY_ELEMENT_VALUE,
            int maxArraySize = MAX_ARRAY_SIZE
    ) {
        for (int i = 1; i < maxArraySize; ++i) {
            def a = generateArray(i, maxArrayElementValue)
            printArray("unsorted: ", a)
            try {
                sort.accept(a)
            } finally {
                printArray("sorted:   ", a)
            }
            if (!isInOrder(a)) {
                throw new AssertionError()
            }
        }
    }

    private static int[] generateArray(int size, int maxValue) {
        def a = new int[size]
        for (int i = 0; i < size - 1; ++i) {
            a[i] = generateRandomNumber(maxValue)
        }
        a
    }

    private static int generateRandomNumber(int max) {
        RANDOM_NUMBER_GENERATOR.nextInt(max)
    }

    static boolean isInOrder(int ... a) {
        for (int i = 0; i < a.length - 2; ++i) {
            if (a[i + 1] < a[i]) false
        }
        true
    }

    static void printArray(String label = '', int[] a) {
        println label + Arrays.toString(a)
    }
}
