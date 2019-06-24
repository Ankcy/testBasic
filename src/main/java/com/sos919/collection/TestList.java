package com.sos919.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ad");
        list.add("ad");
        list.add("ad");
        list.add("ad");
        list.add("ad");
        int a[] = new int[5];
        int size = 4;
        a[size++] = 3;
        System.out.println(a[4]);
        a = Arrays.copyOf(a, 10);
        System.out.println(a.length);
        System.out.println(a[4]);
    }
}
