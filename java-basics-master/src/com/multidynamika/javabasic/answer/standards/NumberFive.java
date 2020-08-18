package com.multidynamika.javabasic.answer.standards;

import com.multidynamika.javabasic.models.ChartModel;
import com.multidynamika.javabasic.utils.JsonUtil;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class NumberFive {
    private static NumberFive instance;

    public static NumberFive instance() {
        if (instance == null) instance = new NumberFive();

        return instance;
    }

    public void run() {
        try {
            var file = new FileInputStream("src/com/multidynamika/javabasic/data.csv");
            var csv = new String(file.readAllBytes());
            var stream = Arrays.stream(csv.split("\n")).skip(1);
            var list = stream.map(s -> {
                var keys = s.split(", ");
                var price = Integer.parseInt(keys[keys.length - 1]);
                var numberFormat = NumberFormat.getNumberInstance(
                        new Locale("in", "ID")
                );

                return new ChartModel(
                        keys[0],
                        keys[1],
                        "Rp. " + numberFormat.format(price)
                );
            }).collect(Collectors.toList());

            System.out.println(JsonUtil.toJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
