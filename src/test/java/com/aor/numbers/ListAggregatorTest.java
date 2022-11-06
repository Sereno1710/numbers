package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    List<Integer> list;
    List<Integer> max_bug_7263;
    List<Integer> distinct_bug_8726;
    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2,5);
        max_bug_7263 = Arrays.asList(-1,-4,-5);
        distinct_bug_8726 = Arrays.asList(1,2,4,2);
    }
    @Test
    public void sum() {


        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int maxbug = aggregator.max(max_bug_7263);
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
        Assertions.assertEquals(-1,maxbug);
    }

    @Test
    public void min() {


        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void Max_bug_8726() {
        List<Integer> list= Arrays.asList(1,2,4,2);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list,deduplicator);
        Assertions.assertEquals(3,distinct);
    }
    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2,2,4,5));

        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(5, distinct);
    }

    @Test
    public void distinct_bug_8726() {

        ListAggregator aggregator = new ListAggregator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        int distinct = aggregator.distinct(distinct_bug_8726,deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}

