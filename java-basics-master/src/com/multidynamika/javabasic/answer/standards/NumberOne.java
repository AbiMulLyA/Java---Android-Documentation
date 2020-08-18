package com.multidynamika.javabasic.answer.standards;

import java.util.List;

public class NumberOne {
    private static NumberOne instance;

    public static NumberOne instance() {
        if (instance == null) instance = new NumberOne();

        return instance;
    }

    public void run() {
        var list = List.of("ibu ratna antar ubi",
                "kasur ini rusak",
                "A nut for a jar of tuna.",
                "Borrow or rob?",
                "Was it a car or a cat I saw?",
                "Yo, banana boy!",
                "UFO tofu?");

        list.stream().map(this::mapToPalindrome).forEach(System.out::println);
    }

    private boolean mapToPalindrome(String text) {
        var myWord = text.toLowerCase().replaceAll("\\W","");
        var reverse = new StringBuffer(myWord).reverse().toString();
        return reverse.equalsIgnoreCase(myWord);
    }
}
