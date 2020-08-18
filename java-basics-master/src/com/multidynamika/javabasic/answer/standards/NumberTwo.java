package com.multidynamika.javabasic.answer.standards;

import java.util.Arrays;
import java.util.List;

public class NumberTwo {
    private static NumberTwo instance;

    public static NumberTwo instance() {
        if (instance == null) instance = new NumberTwo();

        return instance;
    }

    public void run() {
        var lyric = "Aku ingin begini\n" +
                "Aku ingin begitu\n" +
                "Ingin ini itu banyak sekali\n\n" +
                "Semua semua semua\n" +
                "Dapat dikabulkan\n" +
                "Dapat dikabulkan\n" +
                "Dengan kantong ajaib\n\n" +
                "Aku ingin terbang bebas\n" +
                "Di angkasa\n" +
                "Hei… baling baling bambu\n\n" +
                "La... la... la...\n" +
                "Aku sayang sekali\n" +
                "Doraemon\n\n" +
                "La... la... la...\n" +
                "Aku sayang sekali";

        var list = List.of("aku", "ingin", "la...");

        list.stream().map(s -> {
            var word = lyric.toLowerCase();
            var words = List.of(word.split(s));
            var count = words.size() - 1;

            return s + " berjumlah " + count;
        }).forEach(System.out::println);
    }
}
