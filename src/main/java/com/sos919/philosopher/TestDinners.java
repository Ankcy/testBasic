package com.sos919.philosopher;

import java.util.concurrent.BrokenBarrierException;

public class TestDinners {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        DinnerService service = new DinnerService();
        new Philosopher("1", service).start();
        new Philosopher("2", service).start();
        new Philosopher("3", service).start();
        new Philosopher("4", service).start();
        new Philosopher("5", service).start();

    }

}
