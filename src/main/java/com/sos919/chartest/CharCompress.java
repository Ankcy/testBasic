package com.sos919.chartest;

public class CharCompress {

    public static void main(String[] args) {
        // String str = "Theyhavemadeitcleartheywillnotreversethedecisiontoincreaseprices";
        String str = "aadfddddaaaddd";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        char c2 = ' ';
        int j = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            char c1 = chars[i];
            c2 = chars[i + 1];
            if (c1 == c2) {
                j++;
                continue;
            }
            sb.append(c1).append(j);
            c2 = c1;
            j = 1;
        }
        sb.append(c2).append(j);
        System.out.println(sb.toString());

    }
}
