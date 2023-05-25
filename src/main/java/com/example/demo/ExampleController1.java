package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExampleController1 {

    private static List<FullName> namesCache = new ArrayList<>();


    @GetMapping("/example1")
    List<String> hello(@RequestParam int n) {
        var name = n % 2 == 0 ? "A" : "B";
        var fullName = new FullName(name);
        namesCache.add(fullName);

        return namesCache.stream().map(FullName::getName).collect(Collectors.toList());


    }

}

