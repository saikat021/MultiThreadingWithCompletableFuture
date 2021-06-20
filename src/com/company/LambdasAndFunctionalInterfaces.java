package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasAndFunctionalInterfaces {
        /*
        **
        Types of functional interfaces
        1. Function (T)->V
        2. Consumer (T)
        3. Predicate (T)->boolean
        4. Supply()->T
        5. Runnable ()-->
        Runnable does not take any thing just runs a block of code does not return anything
        */
        public static void main(String[] args) {
//            filter map and forEach all run in the same thread as no thread is invoked
        List<String> cities = Arrays.asList("Delhi", "Mumbai","Bangalore");
        cities
                .stream()
                .filter(x->{
            System.out.println("In Filter:"+Thread.currentThread().getName());
            return x.startsWith("D");
                })
                .map(x->{
                    System.out.println("In map:"+Thread.currentThread().getName());
                    return x.toUpperCase();})
                .forEach(x->{
                    System.out.println("In ForEach:"+Thread.currentThread().getName());
                    System.out.println(x);
                });
        cities.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("D");
            }
        }).map(new Function<String, String>() {
            //For doubt clear this actually is not a object of an interface this is an anonymous inner class for interface implementation

            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });



        }
}
