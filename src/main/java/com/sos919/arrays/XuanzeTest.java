package com.sos919.arrays;

public class XuanzeTest {

    public static void main(String[] args) {
        int[] a = { 3, 0, -1, 6, 5 };
        print(a);
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            k = i;
            for (int j = k + 1; j < a.length; j++) {
                if (a[k] > a[j]) {
                    k = j;
                }
                if (i != k) {
                    int temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;
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
