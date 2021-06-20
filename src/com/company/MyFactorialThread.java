package com.company;

import java.math.BigInteger;

public class MyFactorialThread  extends  Thread{
    private long number;
    private BigInteger result;
    MyFactorialThread(long number ){
        this.number=number;
    }
    @Override
    public void run() {
//        System.out.println("Number:"+this.number+" " +Thread.currentThread().getName());
        this.result=new BigInteger("1");
        for (long n=1L;n<=this.number;n++) {
            this.result = this.result.multiply(BigInteger.valueOf(n));
        }
//        System.out.println(this.result);

    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }
}
