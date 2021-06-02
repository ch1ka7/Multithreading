package com.multithreading.producerconsumer.waitnotifysolution;

import java.util.Queue;
import java.util.Random;

/**
 * Created by Chyngyz on 4/2/2019.
 */

public class Producer implements Runnable {
    private final Queue<Integer> sharedQueue;
    private final int MAX_SIZE = 5;

    public Producer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int data = random.nextInt(MAX_SIZE);
            produce(data);
        }
    }

    private void produce(int i) {
        synchronized (sharedQueue) {
            while (sharedQueue.size() == MAX_SIZE) {
                System.out.println("SharedQueue is full! Producer is waiting objects to be consumed by Consumer...");

                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Produced: " + i);
            sharedQueue.add(i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sharedQueue.notify();
        }
    }
}
