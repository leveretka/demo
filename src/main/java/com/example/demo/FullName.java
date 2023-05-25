package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Random;

public class FullName {
    private static Random random = new Random(System.nanoTime());

    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public FullName(String name) {
        this.name = name;
        try {
            content = Files.readString(Path.of(name + ".txt"));
        } catch (IOException e) {
            content = "";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullName fullName = (FullName) o;

        if (!Objects.equals(name, fullName.name)) return false;
        return Objects.equals(content, fullName.content);
    }

    @Override
    public int hashCode() {
        return random.nextInt();
    }
}
