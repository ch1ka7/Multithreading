package com.multithreading.producerconsumer.semaphoressolution.workers;

import com.multithreading.producerconsumer.semaphoressolution.resource.MyQueue;

/**
 * Created by Chyngyz on 4/4/2019.
 */

public class Consumer implements Runnable {
    private MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            myQueue.get();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
