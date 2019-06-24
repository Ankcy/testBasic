package com.sos919.redislock;

public class Test {
    
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
    
}