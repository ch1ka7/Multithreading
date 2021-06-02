package com.multithreading.producerconsumer.waitnotifysolution;

import java.util.Queue;

/**
 * Created by Chyngyz on 4/2/2019.
 */

public class Consumer implements Runnable {
    private Queue<Integer> sharedQueue;

    public Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    private void consume() {
        synchronized (sharedQueue) {
            while (sharedQueue.isEmpty()) {
                System.out.println("SharedQueue is empty! Consumer is waiting for objects to be produced by Producer...");

                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Consumed: " + sharedQueue.poll());
            sharedQueue.notify();
        }
    }
}
