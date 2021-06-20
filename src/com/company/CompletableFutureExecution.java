package com.company;

import javax.sound.midi.SysexMessage;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExecution {
    public static CompletableFuture<BigInteger> compute(int x ){
//        System.out.println("Computing Factorial of :"+x+" in thread :"+Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(new Supplier<BigInteger>() {
            @Override
            public BigInteger get() {
                return calcuateFactorial(x);
            }
        });
    }
    public static BigInteger calcuateFactorial(int x ){
//        System.out.println("Calculating Factorial of: "+x+" in thread :"+Thread.currentThread().getName());
        BigInteger res=new BigInteger("1");
        for (int i=1;i<=x;i++){
            res=res.multiply(BigInteger.valueOf(i));
        }
        return res;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int  [] arr={10000,20000,30000,40000,50000,60000,70000,80000};
//        int [] arr={2,3,4,5};
        long start=System.currentTimeMillis();
        List <CompletableFuture<BigInteger>> completableFutureList=new ArrayList<CompletableFuture<BigInteger>>();
        for (int i=0;i<arr.length;i++){
//            int ele=arr[i];
            CompletableFuture<BigInteger> completableFuture=compute(arr[i]);
//            completableFuture.thenAccept(x->System.out.println(x));
            completableFutureList.add(completableFuture);
//            completableFuture.get();//Except for this the main thread will complete execution and the background
            // threads will not be able to complete execution
            //Blocking call but not a good approach
            //Similar to thread.join()
            //Sequential program
            //Never use this like this
        }
        completableFutureList.stream().forEach(x->{
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
        System.out.println("Time taken for execution:"+(System.currentTimeMillis()-start));



        //Advantages of using completable futures:
        //1. Main method not waiting for the user threads to finish.
        //2. No need of manually spawning threads.
        //3. It allocates the resources of JVM cores as per the number of threads and the threads dont get throttled.
        //Threads dont continue context switching more than the actual computation.
        //4. Highly scalable

    }
}
