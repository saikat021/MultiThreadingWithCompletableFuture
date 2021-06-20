package com.company;

public class ParallelFactorial {

    public static void main(String[] args) throws InterruptedException {

        long [] arr={10000,20000,30000,40000,50000,60000,70000,80000};
        int n=arr.length;
        //Multiple User threads execution
        long start=System.currentTimeMillis();
        MyFactorialThread[] threads=new MyFactorialThread[n];
        for (int i=0;i<arr.length;i++){
            threads[i]=new MyFactorialThread(arr[i]);
            threads[i].start();
            //create all the threads and allow them to execute
        }

        /*
        **
        Thread obj=new Thread()
        obj.start() starting the thread execution
        obj.join() waiting in the main thread/ spawning thread to finish the execution of the spawned/created thread
        this can take a lot of time as threads often become unresponsive
        so obj.join(3000) timeout of 3000ms to move on with execution
        */


        for (int i=0;i<arr.length;i++){
            threads[i].join();//Wait for the thread to complete execution if not over
            //Main thread is blocked
            System.out.println(threads[i].getResult());

        }
        System.out.println(" Parallel Time of Execution"+(System.currentTimeMillis()-start)+" ms");
        //Drawbacks
        //1. Only 8 threads in parallel because of 8 cores-------->thrashing if large number of threads present large  and less cores
        //Threads performing context switching more than doing actual execution
        //2. async programming my main thread instead of sitting idle can do something

        //Executors and Future and CompletableFutures
        //Does low level work of assigning threads to cores and executing. Does low level work of contact switching etc.
//        Executor executor= Executors.newSingleThreadExecutor();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Helo");
//            }
//        });


    }
}
