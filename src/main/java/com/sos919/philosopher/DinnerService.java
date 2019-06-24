package com.sos919.philosopher;

public class DinnerService {

    private boolean used[] = { true, false, false, false, false, false };

    public synchronized void takeChopsticks() {
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        int j = i == 5 ? 1 : i + 1;
        int odd, even;
        if (i % 2 == 0) {
            even = i;
            odd = j;
        } else {
            even = j;
            odd = i;
        }
        while (used[odd]) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        used[odd] = true;
        while (used[even]) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        used[even] = true;
    }

    public synchronized void putChopsticks() {
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name);
        int j = i == 5 ? 1 : i + 1;
        used[i] = false;
        used[j] = false;
        notifyAll();
    }

}
