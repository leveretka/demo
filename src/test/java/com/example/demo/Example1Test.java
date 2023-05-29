package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import org.skyscreamer.jsonassert.ValueMatcher;

import static org.junit.jupiter.api.Assertions.*;

class Example1Test {

    @Test
    void test() {
        var instance = new BigObject().new SmallObject();
        VM.current().details();
    }

}