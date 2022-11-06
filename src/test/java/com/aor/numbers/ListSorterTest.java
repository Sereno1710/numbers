package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    @Test
    public void sort() {
        List<Integer> list = helper.helper(3,2,6,1,4,5,7);
        List<Integer> expected = helper.helper(1,2,3,4,5,6,7);
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
