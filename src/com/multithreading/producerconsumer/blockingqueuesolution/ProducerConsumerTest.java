package com.multithreading.producerconsumer.blockingqueuesolution;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Chyngyz on 4/3/2019.
 */

public class ProducerConsumerTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        producerThread.start();
        consumerThread.start();
    }
}
