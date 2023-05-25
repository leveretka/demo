package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ExampleController2 {

    private Map<FullName, Integer> namesCache = new HashMap<>();


    @GetMapping("/example2")
    List<String> hello(@RequestParam int n) {
        var name = n % 2 == 0 ? "A" : "B";
        var fullName = new FullName(name);
        namesCache.compute(fullName, (k, v) -> (v == null) ? 0 : v + 1);

        return namesCache.keySet().stream().map(FullName::getName).collect(Collectors.toList());
    }

}

