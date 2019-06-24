package com.sos919.chartest;

public class CharReverse1 {

    public static void main(String[] args) {
        String str = "This   is a  Test ";
        // 先全部逆转，在分割，然后单词逆转
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        reverse(chars, start, end);
        print(chars);
        
        int j = start;
        while (start < end) {

            if (j <= end && chars[j] != ' ') {
                j++;
            } else {// 出现可替换的单词，可能该单词后出现连续几个空格
                reverse(chars, start, j - 1);
                while (j <= end && chars[j] == ' ') {// 过滤所有的空格，如果是结束则不会执行该过程
                    j++;
                }
                start = j;
            }

        }
        print(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char cTemp = chars[start];
            chars[start] = chars[end];
            chars[end] = cTemp;
            start++;
            end--;
        }
    }

    private static void print(char[] chars) {
        System.out.println();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }

}
