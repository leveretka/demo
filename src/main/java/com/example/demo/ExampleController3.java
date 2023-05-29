package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ExampleController3 {

    private Map<FullName, Integer> namesCache = new HashMap<>();
    private List<BigObject.SmallObject> smallObjects = new ArrayList<>();


    @GetMapping("/example3")
    String hello() {
        BigObject.SmallObject smallObject = new BigObject.SmallObject();
        smallObjects.add(smallObject);

        return smallObject.hello();
    }

}


class BigObject {

    private List<Object> objects;

    public BigObject() {
        this.objects = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            objects.add("Hello" + i);
        }
    }

    public String hello() {
        return "Hello from the BigObject!";
    }

    static class SmallObject {

        public String hello() {
            return "Hello from the SmallObject!";
        }

    }
}

