package com.sos919.philosopher;

public class Philosopher extends Thread {

    private DinnerService dinnerService;

    public Philosopher(String name, DinnerService dinnerService) {
        super(name);
        this.dinnerService = dinnerService;
    }

    @Override
    public void run() {
        while (true) {
            thinking();
            dinnerService.takeChopsticks();
            eating();
            dinnerService.putChopsticks();
        }
    }

    private void thinking() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Philosoper " + Thread.currentThread().getName() + " is thinking.");
    }

    private void eating() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Philosoper " + Thread.currentThread().getName() + " is eating.");
    }

}