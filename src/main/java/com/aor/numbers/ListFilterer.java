package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer{
    private GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        List<Integer> list2 = new ArrayList<>();
        for (Integer i:list){
            if (filter.accept(i)){
                list2.add(i);
            }
        }
        return list2;
    }
}