package com.alexandervbarkov.algorithms.sort

import spock.lang.Specification

import static com.alexandervbarkov.algorithms.sort.QuickSort.sort
import static com.alexandervbarkov.algorithms.sort.SortTestUtils.*

class QuickSortTest extends Specification {
    def "Sort random arrays"() {
        expect:
        testSort({ sort(it) })
    }

    def "Sort specific arrays"() {
        setup:
        def a = list as int[]
        printArray 'unsorted: ', a

        when:
        sort(a)

        then:
        isInOrder(a)

        cleanup:
        printArray 'sorted:   ', a

        where:
        list << [
                [92, 2, 22, 82, 99, 55, 55, 30, 99],
                [92, 2, 22, 82, 0, 55, 55, 30, 0],
                [0, 3, 3, 2, 0],
                [15, 3, 2, 1, 9, 5, 9, 7, 8, 6]
        ]
    }
}
