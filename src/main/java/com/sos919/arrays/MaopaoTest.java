package com.sos919.arrays;

public class MaopaoTest {

    public static void main(String[] args) {
        int[] a = { 3, 0, -1, 6, 5 };
        print(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("");
            print(a);
        }
        System.out.println("");
        print(a);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
