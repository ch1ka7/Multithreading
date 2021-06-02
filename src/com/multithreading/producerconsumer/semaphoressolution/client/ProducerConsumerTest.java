package com.multithreading.producerconsumer.semaphoressolution.client;

import com.multithreading.producerconsumer.semaphoressolution.resource.MyQueue;
import com.multithreading.producerconsumer.semaphoressolution.workers.Consumer;
import com.multithreading.producerconsumer.semaphoressolution.workers.Producer;

/**
 * Created by Chyngyz on 4/4/2019.
 */

public class ProducerConsumerTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        Thread producerThread = new Thread(new Producer(myQueue));
        Thread consumerThread = new Thread(new Consumer(myQueue));

        producerThread.start();
        consumerThread.start();
    }
}
