package com.sos919.philosophersemaphore;

public class PhilosopherSemaphore extends Thread {

    private SemaphoreService semaphoreService;

    public PhilosopherSemaphore(String name, SemaphoreService semaphoreService) {
        super(name);
        this.semaphoreService = semaphoreService;
    }

    @Override
    public void run() {
        while (true) {
            thinking();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreService.philosopherEating();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreService.recoverResource();
        }
    }
    private void thinking(){
        System.out.println("Philosopher "+Thread.currentThread().getName() + " thinking.");
    }

}