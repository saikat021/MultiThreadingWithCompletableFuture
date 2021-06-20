package com.company;

import java.math.BigInteger;
import java.util.Arrays;

public class SerialFactorial {
    public static void main(String[] args) {


        long [] arr={10000,20000,30000,40000,50000,60000,70000,80000};
        //Normal Main thread execution
        long start=System.currentTimeMillis();
        Arrays.stream(arr).mapToObj(SerialFactorial::myfactorial).forEach(System.out::println);
        System.out.println(" Serial Time taken for  factorial execution "+ (System.currentTimeMillis()-start)+" ms");


    }
    public static BigInteger myfactorial(long n){
        BigInteger result=new BigInteger("1");
        for (long i=1L;i<=n;i++){
            result=result.multiply(BigInteger.valueOf(Long.valueOf(i)));
        }
        return result;
    }
}
