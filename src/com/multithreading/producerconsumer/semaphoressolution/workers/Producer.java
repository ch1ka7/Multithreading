package com.multithreading.producerconsumer.semaphoressolution.workers;

import com.multithreading.producerconsumer.semaphoressolution.resource.MyQueue;

import java.util.Random;

/**
 * Created by Chyngyz on 4/4/2019.
 */

public class Producer implements Runnable {
    private MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int data = random.nextInt(100);
            myQueue.put(data);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
