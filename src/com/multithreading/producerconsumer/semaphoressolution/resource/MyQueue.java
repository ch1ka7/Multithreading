package com.multithreading.producerconsumer.semaphoressolution.resource;

import java.util.concurrent.Semaphore;

/**
 * Created by Chyngyz on 4/4/2019.
 */

public class MyQueue {
    private int item;

    // semaphoreConsumer is initialized with 0 permit
    // to ensure put() method executes first
    private Semaphore semaphoreConsumer = new Semaphore(0);
    private Semaphore semaphoreProducer = new Semaphore(1);

    // get an item from the buffer
    public void get() {
        try {
            // Before Consumer can get an item
            // it must acquire a permit from semaphoreConsumer
            semaphoreConsumer.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Consumer consumed: " + item);

        semaphoreProducer.release();
    }

    public void put(int item) {
        try {
            // Before Consumer can get an item
            // it must acquire a permit from semaphoreConsumer
            semaphoreProducer.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        this.item = item;
        System.out.println("Producer producer: " + item);

        semaphoreConsumer.release();
    }
}
