package com.sos919.chartest;

public class CharReplace {

    public static void main(String[] args) {
        String longStr = "fjkdwffjkdahjkdfohfljsajkd";
        String shortStr = "jkd";
        char[] longS = longStr.toCharArray();
        char[] shortS = shortStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        int j = 0;
        StringBuffer sbTemp = new StringBuffer();
        for (int i = 0; i < longS.length; i++) {
            if (j < shortS.length && longS[i] == shortS[j]) {
                j++;
                sbTemp.append(longS[i]);
                continue;
            } else {
                if (j == shortS.length) {
                    sbTemp = new StringBuffer();
                }
                sb.append(sbTemp);
                sb.append(longS[i]);
                sbTemp = new StringBuffer();
                j = 0;
            }
        }
        System.out.println(sb.toString());

    }

}
