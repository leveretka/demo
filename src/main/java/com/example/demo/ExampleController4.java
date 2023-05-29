package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController4 {
    ThreadLocal<FullName> localFullName = new ThreadLocal<>();

    @GetMapping("/example4")
    String hello(@RequestParam int n) {
        var name = n % 2 == 0 ? "A" : "B";
        var fullName = new FullName(name);
        localFullName.set(fullName);

        return fullName.getName();
    }

}
