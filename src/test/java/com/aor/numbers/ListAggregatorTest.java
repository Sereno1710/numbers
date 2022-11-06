package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.code.Stub;

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
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override
            public List<Integer> deduplicate(List<Integer> list,GenericListSorter sorter) {
                return Arrays.asList(1,2,4);
            }
        }
        ListSorter sorter= new ListSorter();
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list,deduplicator,sorter);

        Assertions.assertEquals(3,distinct);
    }
    @Test
    public void distinct() {
        class stub implements GenericListDeduplicator{
            @Override
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter list2) {
                return Arrays.asList(1,2,4);
            }
        }
        class stub_dedu implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = new stub();
        GenericListSorter sorter = new stub_dedu();
        int distinct = aggregator.distinct(distinct_bug_8726,deduplicator,sorter);

        Assertions.assertEquals(3, distinct);
    }
}

