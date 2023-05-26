package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ExampleController3 {

    private Map<FullName, Integer> namesCache = new HashMap<>();
    private BigObject.SmallObject smallObject;


    @GetMapping("/example3")
    String hello(@RequestParam int n) throws InterruptedException {
        smallObject = new BigObject().new SmallObject();

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

    class SmallObject {

        public String hello() {
            return "Hello from the SmallObject!";
        }

    }
}

