package com.sos919.chartest;

import java.util.ArrayList;
import java.util.List;

public class CharReverse {

    public static void main(String[] args) {
        String str = "This is a Test";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                list.add(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(c);
            }
        }
        list.add(sb.toString());
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

}
