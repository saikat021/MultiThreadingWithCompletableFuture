package com.company;

public class MyThread {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());
        System.out.println("Line 8 "+Thread.currentThread().getName());
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am in run function:"+Thread.currentThread().getName());
            }
        });
        //created a thread object does not invoke / start execution of the thread
        thread.start();// this invokes the run function
        // main thread does not wait for any other thread
        // JVM  waits  to finish execution of all the main thread and the user created thread to complete
        //spawning a new thread from the main thread
        System.out.println("Line 14 "+Thread.currentThread().getName());



    }
}
