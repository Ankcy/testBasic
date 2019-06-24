package com.sos919.philosophersemaphore;

import java.util.concurrent.BrokenBarrierException;

public class TestDinners {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        SemaphoreService service = new SemaphoreService();
        new PhilosopherSemaphore("1", service).start();
        new PhilosopherSemaphore("2", service).start();
        new PhilosopherSemaphore("3", service).start();
        new PhilosopherSemaphore("4", service).start();
        new PhilosopherSemaphore("5", service).start();
    }

}
