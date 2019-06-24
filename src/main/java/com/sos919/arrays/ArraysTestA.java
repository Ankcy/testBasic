package com.sos919.arrays;

import java.util.Random;

public class ArraysTestA {

    public static void main(String[] args) {
        Random r = new Random();
        int m = 8;
        int n = 8;
        int[][] a = new int[m][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(10);
            }
        }
        print(a);
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (row[i] || col[j]) {
                    a[i][j] = 0;
                }
            }
        }
        System.out.println("");
        print(a);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }

}
