package com.sos919.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<String>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.add("" + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        
        List<String> list2 = new ArrayList<String>();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.add("" + i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
        
        /*CopyOnWriteArraySet<String> set1 = new CopyOnWriteArraySet<String>();
        set1.add("");*/
    }

}
