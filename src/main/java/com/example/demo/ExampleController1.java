package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleController1 {


    @GetMapping("/example1")
    List<String> hello(@RequestParam int n) {
        var  names = new ExampleNamesCache().getNamesCache();
        var name = n % 2 == 0 ? "A" : "B";
        var fullName = new FullName(name);
        names.add(fullName);

        return names.stream().map(FullName::getName).toList();

    }

}

class ExampleNamesCache {
    static List<FullName> namesCache = new ArrayList<>();

    public List<FullName> getNamesCache() {
        return namesCache;
    }
}

