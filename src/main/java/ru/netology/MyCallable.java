package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable <Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
       Integer counter = 1;
       for (int i=1;i<5;i++){
            System.out.println("Hello! My name is:" + name + " My message: " + i);
            Thread.sleep(400);
            counter++;
       }return counter;
    }
}





