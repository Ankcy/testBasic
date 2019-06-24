package com.sos919.ascii;

public class AsciiTest {
    
    public static void main(String[] args) {
        String valA = "fadfjWDewjCFfaDEdcbA";
        System.out.println(toDaxie(valA));
        System.out.println(toXiaoxie(valA));
    }

    private static String toXiaoxie(String valA) {
        char[] arrays = valA.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrays.length; i++) {
            char c1 = arrays[i];
            int ascii = (int)c1;
            if(ascii >= 97 && ascii <= 122){
                ascii = ascii - 32;
                arrays[i] = (char)ascii;
            }
            sb.append(arrays[i]);
        }
        return sb.toString();
    }

    private static String toDaxie(String valA) {
        char[] arrays = valA.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrays.length; i++) {
            char c1 = arrays[i];
            int ascii = (int)c1;
            if(ascii >= 65 && ascii <= 90){
                ascii = ascii + 32;
                arrays[i] = (char)ascii;
            }
            sb.append(arrays[i]);
        }
        return sb.toString();
    }
    
}

