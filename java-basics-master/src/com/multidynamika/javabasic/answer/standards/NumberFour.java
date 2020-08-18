package com.multidynamika.javabasic.answer.standards;

import com.multidynamika.javabasic.models.FruitModel;
import java.io.FileOutputStream;
import java.util.List;

public class NumberFour {
    private static NumberFour instance;

    public static NumberFour instance() {
        if (instance == null) instance = new NumberFour();

        return instance;
    }

    public void run() {
        var list = List.of(
                new FruitModel(21, "Pears - 1 Kg", 69),
                new FruitModel(22, "Pomegranate - 1 Kg", 95),
                new FruitModel(23, "Raspberry - 1/4 Kg", 160),
                new FruitModel(24, "Strawberry - 1/4 Kg", 180),
                new FruitModel(25, "Water Melon - 1 Kg", 28)
        );

        // 1
        try {
            var file = new FileOutputStream("src/com/multidynamika/javabasic/file.json");
            file.write(list.toString().getBytes());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2
        list.stream()
                .filter(s -> s.name.contains("berry"))
                .forEach(System.out::println);

        // 3
        list.stream()
                .filter(s -> s.price >= 50 && s.price <= 100)
                .forEach(System.out::println);
    }
}
