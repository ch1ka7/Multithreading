package com.multithreading.producerconsumer.blockingqueuesolution;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Chyngyz on 4/3/2019.
 */

public class Consumer implements Runnable {
    private BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int data = sharedQueue.take();
                System.out.println("Consumed: " + data);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
