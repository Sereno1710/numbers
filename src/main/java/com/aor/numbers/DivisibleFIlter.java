package com.aor.numbers;

import com.sun.org.apache.xpath.internal.operations.Div;

public class DivisibleFIlter implements  GenericListFilter{
    private Integer n;
    public DivisibleFIlter(Integer n){
        this.n=n;
    }
    public boolean accept(Integer number){
        if(number % n ==0) return true;
        return false;
    }
}
