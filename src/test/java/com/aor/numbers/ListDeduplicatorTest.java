package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list = helper.helper(1,2,4,2,5);
    List <  Integer> expected = helper.helper(1,2,4,5);
    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
}
