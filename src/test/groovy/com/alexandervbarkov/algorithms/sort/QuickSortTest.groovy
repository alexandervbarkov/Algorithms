package com.alexandervbarkov.algorithms.sort

import spock.lang.Specification

import static com.alexandervbarkov.algorithms.sort.QuickSort.sort
import static com.alexandervbarkov.algorithms.sort.SortTestUtils.isInOrder
import static com.alexandervbarkov.algorithms.sort.SortTestUtils.testSort

class QuickSortTest extends Specification {
    def "Sort random arrays"() {
        expect:
        testSort({ sort(it) })
    }

    def "Sort specific arrays"() {
        expect:
        isInOrder(sort(a as int[]))

        where:
        a << [
                [92, 2, 22, 82, 99, 55, 55, 30, 99],
                [92, 2, 22, 82, 0, 55, 55, 30, 0],
                [0, 3, 3, 2, 0],
                [15, 3, 2, 1, 9, 5, 9, 7, 8, 6]
        ]
    }
}
