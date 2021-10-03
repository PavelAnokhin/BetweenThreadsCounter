package ru.netology;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        int counterMessage = 0;

        Callable <Integer> Callable1 = new MyCallable("Thread1");
        Callable <Integer> Callable2 = new MyCallable("Thread2");
        Callable <Integer> Callable3 = new MyCallable("Thread3");
        Callable <Integer> Callable4 = new MyCallable("Thread4");
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer>> poolthreads = new LinkedList<>();
        poolthreads.add(Callable1);
        poolthreads.add(Callable2);
        poolthreads.add(Callable3);
        poolthreads.add(Callable4);
        List<Future<Integer>> result = threadPool.invokeAll(poolthreads);
        for (Future future : result ){
            counterMessage = counterMessage + (Integer)future.get();
        }
        System.out.println("Qty of receiving message" + counterMessage);
        Integer futureInvoakObjects = threadPool.invokeAny(poolthreads);
        System.out.println("For InvokeAny threads we have:" + futureInvoakObjects);
        threadPool.shutdown();

    }
    
}
