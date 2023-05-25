package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

    private final FullName fullName;

    private static List<FullName> namesCache = new ArrayList<>();

    public Example1(String name) {
        fullName = new FullName(name);
        namesCache.add(fullName);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 79; i++) {
            new Example1("A");
            System.out.println("A");
            new Example1("B");
            System.out.println("B");
            new Example1("C");
            System.out.println("C");
        }

        Thread.sleep(1000*3600);

    }

}
