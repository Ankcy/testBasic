package com.sos919;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;



public class TestInitialize {
    
    public static void main(String[] args) {
        /*new Test();
        System.out.println();
        new Test();*/
        Integer a[] = {3,4,1,4,8};
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);
        }
        a = new Integer[s.size()];
        a = s.toArray(a);
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
}











class A {
    A(int maker) {
        System.out.println("A(" + maker + ")");
    }
}

class Test {
    Test() {
        System.out.println("Test()");
    }
    static {
        System.out.println("静态块");
        A a4 = new A(4);
    }
    static A a1 = new A(1);
    {
        System.out.println("非静态的代码块"); 
    }
    A a2 = new A(2);
    A a3 = new A(3);
    static void f() {System.out.println("f()");}
    static A a5 = new A(5);
}
