package com.example.demo;


import org.openjdk.jol.info.ClassLayout;

import java.lang.ref.WeakReference;
import java.util.*;

public class Example1 {

    private final FullName fullName;

    private static List<FullName> namesCache = new ArrayList<>();


    private WeakReference<BigObject> bigObject;


    public void execute() {
        var ref = bigObject.get();
        if (ref == null) {
            ref = recreateBigObject();
            bigObject = new WeakReference<>(ref);
        }
        ref.hello();
    }

    private BigObject recreateBigObject() {
        return null;
    }


    public Example1(String name) {
        fullName = new FullName(name);
        namesCache.add(fullName);
    }

    public static void main(String[] args) {

        try(var loader = new CustomClassloader(Example1.class.getClassLoader())) {
            var clazz = loader.loadClass("com.example.classloader.MyExampleClass");
            var instance = clazz.getConstructor().newInstance();
            clazz.getMethod("doSomething").invoke(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void run() {
        var plugins = new ArrayDeque<Plugin>();
        plugins.add(new JavaPlugin());
        plugins.add(new CPPPlugin());
        for (var plugin = plugins.poll(); plugin != null; plugin = plugins.poll()) {
            plugin.execute();
        }
    }

    void testLayout() {
        var instance = new BigObject().new SmallObject();
        ClassLayout.parseInstance(instance).toPrintable();
    }

}
