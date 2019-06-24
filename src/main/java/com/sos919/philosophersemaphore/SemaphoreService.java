package com.sos919.philosophersemaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreService {

    Semaphore semaphore = new Semaphore(2);

    public void philosopherEating() {
        try {
            semaphore.acquire();
            System.out.println("Philosopher "+Thread.currentThread().getName() + " eating.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void recoverResource() {
        System.out.println("Philosopher "+Thread.currentThread().getName() + " thinking.");
        semaphore.release();
        System.out.println("");
    }

}
