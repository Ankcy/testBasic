package com.sos919.arrays;

public class KuaisuTest {

    public static void main(String[] args) {
        int[] a = { 5, 2, 8, 9, 2, 3, 4, 9 };
        print(a);
        // 找一个排序因子key
        // 找中间数
        int i = 0;
        int j = a.length - 1;
        quickSort(a, i, j);
        System.out.println("");
        print(a);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int key = a[low];
        // 4.完成一趟排序
        while (i < j) {
            // 4.1从右往左找到第一个小于key的数
            while (i < j && a[j] > key) {
                j--;
            }
            // 4.2从左往右找到第一个大于key的数
            while (i < j && a[i] <= key) {
                i++;
            }
            // 4.3 交换
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // 4.4 调整key的位置
        int temp = a[i];
        a[i] = a[low];
        a[low] = temp;
        System.out.println("");
        print(a);
        // 对左边进行排序
        quickSort(a, low, i - 1);
        // 对右边进行排序
        quickSort(a, i + 1, high);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
