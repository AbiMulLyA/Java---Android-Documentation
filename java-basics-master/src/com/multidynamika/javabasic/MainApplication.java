package com.multidynamika.javabasic;

import com.multidynamika.javabasic.answer.standards.*;
import com.multidynamika.javabasic.classes.*;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApplication<T> {

    public static void main(String[] args) {
//        javaBasicExercises();
//        javaStandardsExercises();
//        classMaterial();
        oopMaterial();
    }

    private static void oopMaterial() {
        var cat = new Cat();
        var anggora = new Anggora();

        cat.sleep();
        anggora.sleep();
        cat.sound();
        anggora.sleep();
    }

    private static void javaStandardsExercises() {
        NumberOne.instance().run();
        NumberTwo.instance().run();
        NumberThree.instance().run();
        NumberFour.instance().run();
        NumberFive.instance().run();
    }

    private static void classMaterial() {
        var java = ProgrammingLanguage.instance();
        java.name = "Java";
        java.frameworks = List.of(".ASP", "SPRING", "Android");
        java.print();

        var postResponse = new BaseResponse<List<PostModel>>();
        postResponse.data = List.of();

        var userResponse = new BaseResponse<String>();
        userResponse.data = "HELLO";
    }

    private static void basicSyntaxMaterial() {
        var post = new HashMap<String, Object>();

        post.put("userId", 1);
        post.put("id", 1);
        post.put("title", "sunt aut facere repellat provident occaecati " +
                "excepturi optio reprehenderit");
        post.put("body", "quia et suscipit suscipit recusandae consequuntur " +
                "expedita et cum reprehenderit molestiae ut ut quas totam " +
                "nostrum rerum est autem sunt rem eveniet architecto");

        System.out.println(post);

        var postModel = new PostModel(
                1,
                1,
                "sunt aut facere repellat provident occaecati " +
                        "excepturi optio reprehenderit",
                "quia et suscipit suscipit recusandae consequuntur " +
                        "expedita et cum reprehenderit molestiae ut ut " +
                        "quas totam nostrum rerum est autem sunt rem " +
                        "eveniet architecto");

        print("HELLO");
        print("DANGER");
        print(null);

        System.out.println(message(null));
        System.out.println(message("null"));
        System.out.println(message("hello"));

        try {
            var inputStream = new FileInputStream("src/com/multidynamika/javabasic/app.log");
            System.out.println(new String(inputStream.readAllBytes()));
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            var outputStream = new FileOutputStream("src/com/multidynamika/javabasic/posts.json");
            outputStream.write(postModel.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void javaBasicExercises() {
        numberTwo();
        numberFour();
        numberFive();
        numberSix();
        numberSeven();
        numberEight();
        numberNine();
    }

    private static void numberNine() {
        characterLength("ilmiah");
        System.out.println("\n---\n");
        characterLength("lari pagi");
    }

    private static void characterLength(String text) {
        System.out.println("Input: " + text);
        var length = Arrays.stream(text.split(""))
                .map(MainApplication::mapToOne)
                .reduce(0, Integer::sum);
        System.out.println("Output: " + length);
    }

    private static int mapToOne(String s) {
        return 1;
    }

    private static void numberEight() {
        var numbers = List.of(3, 1, 7, 4, 5, 6, 8, 2);
        var total = numbers.stream()
                .filter(item -> !item.equals(Collections.max(numbers)))
                .reduce(0, Integer::sum);
        System.out.println(total);
    }

    private static void numberSeven() {
        leapYear(1, 4);
        System.out.println("\n---\n");
        leapYear(2000, 2020);
    }

    private static void leapYear(int start, int end) {
        IntStream.rangeClosed(start, end).boxed()
                .map(MainApplication::mapToLeap)
                .forEach(System.out::println);
    }

    private static String mapToLeap(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            return year + " adalah tahun kabisat";
        else return year + " bukan tahun kabisat";
    }

    private static void numberSix() {
        IntStream.rangeClosed(1, 1000)
                .boxed().map(MainApplication::mapToEvenOrOdd)
                .forEach(System.out::println);
    }

    private static String mapToEvenOrOdd(int number) {
        if (number % 100 == 0) return number + ". Kelipatan seratus";
        else if (number % 8 == 0)
            return number + ". Genap dan kelipatan delapan";
        else if (number % 2 == 1 && number % 7 == 0)
            return number + ". Ganjil dan kelipatan tujuh";
        else if (number % 2 == 0) return number + ". Genap";
        else return number + ". Ganjil";
    }

    private static String message(String level) {
        if (level == null) return "LOW";

        if (level.equals("null")) {
            return level;
        }

        return level.toUpperCase();
    }

    private static void print(String message) {
        if (message == null) {
            return;
        }

        if (message.equals("DANGER")) {
            System.out.println("RUN... RUN...");
            return;
        }

        System.out.println(message);
    }

    private static class PostModel {
        String title, body;
        int userId, id;

        public PostModel(int userId, int id, String title, String body) {
            this.title = title;
            this.body = body;
            this.userId = userId;
            this.id = id;
        }

        @Override
        public String toString() {
            return "{" + "\"title\":\"" + title + '\"' + ", \"body\":\"" + body +
                    '\"' + ", \"userId\":" + userId + ", \"id\":" + id + '}';
        }
    }

    private static void numberFive() {
        var age = (int) (Math.random() * 29) + 1;

        System.out.println(age);

        if (age >= 21) System.out.println("DEWASA");
        else if (age >= 13) System.out.println("REMAJA");
        else if (age >= 9) System.out.println("BIMBINGAN ORANG TUA");
        else System.out.println("SEMUA UMUR");
    }

    private static void numberFour() {
        var list = List.of("Aku", "bukanlah", "Superman", "Aku",
                "juga", "bisa", "nangis");

        var message = list.stream().distinct()
                .collect(Collectors.toList());

        System.out.println(message);
    }

    private static void numberTwo() {
        List<Integer> range = IntStream.rangeClosed(1, 1000)
                .boxed().collect(Collectors.toList());

        range.stream()
                .filter(MainApplication::isPrime)
                .forEach(System.out::println);
    }

    private static boolean isPrime(Integer s) {
        if (s < 2) return false;

        for (int i = 2; i < s; i++) {
            if (s % i == 0) return false;
        }

        return true;
    }
}