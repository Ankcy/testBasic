package com.sos919.join;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest2 t2 = new ThreadJoinTest2("t2");
        ThreadJoinTest t1 = new ThreadJoinTest("t1", t2);
        /**
         * join方法可以在start方法前调用时，并不能起到同步的作用
         */
        t1.start();
        // Thread.yield();
        t2.start();
        t1.join();
        System.out.println("end...");
    }

}

class ThreadJoinTest extends Thread {
    
    private ThreadJoinTest2 t2;
    
    public ThreadJoinTest(String name, ThreadJoinTest2 t2) {
        super(name);
        this.t2 = t2;
    }

    @Override
    public void run() {
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}

class ThreadJoinTest2 extends Thread {
    
    public ThreadJoinTest2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}
