package com.sos919;
public class TestFinal {
    public static void main(String[] args)  {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println("A="+buffer.toString());
    }
}
 
class MyClass {
     
    void changeValue(final StringBuffer buffer) {
        buffer.append("world");
        //buffer = new StringBuffer();
        System.out.println("B="+buffer.toString());
    }
}