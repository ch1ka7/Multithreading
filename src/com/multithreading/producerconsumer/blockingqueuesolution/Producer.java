package com.multithreading.producerconsumer.blockingqueuesolution;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Chyngyz on 4/3/2019.
 */

public class Producer implements Runnable {
    private BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int data = random.nextInt(10);

            try {
                sharedQueue.put(data);
                System.out.println("Produced: " + data);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
