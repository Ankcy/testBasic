package com.sos919.blockqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestBlockingQueue {

    private static LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(10);
    
    public static void main(String[] args) {
        ScheduledExecutorService product = Executors.newScheduledThreadPool(1);
        Random random = new Random();
        product.scheduleAtFixedRate(() -> {
            int value = random.nextInt(101);
            try{
                blockingQueue.offer(value);  //offer()方法就是网队列的尾部设置值
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);  //每200毫秒执行线程

        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(2000);
                    System.out.println("开始取值");
                    List<Integer> list = new LinkedList<>();
                    blockingQueue.drainTo(list);  //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
