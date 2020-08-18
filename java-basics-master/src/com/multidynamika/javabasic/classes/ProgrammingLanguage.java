package com.multidynamika.javabasic.classes;

import java.util.List;

public class ProgrammingLanguage {
    public String name = "";
    public List<String> frameworks = List.of();

    private static ProgrammingLanguage language;

    public static ProgrammingLanguage instance() {
        if (language == null) language = new ProgrammingLanguage();

        return language;
    }

    public void print() {
        System.out.println(name + " Programming Language with " +
                String.join(", ", frameworks) + " frameworks");
    }
}