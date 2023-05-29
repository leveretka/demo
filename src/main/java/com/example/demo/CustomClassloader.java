package com.example.demo;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassloader extends URLClassLoader {
    public CustomClassloader(ClassLoader parent) {
        super(new URL[0], parent);
    }
}
