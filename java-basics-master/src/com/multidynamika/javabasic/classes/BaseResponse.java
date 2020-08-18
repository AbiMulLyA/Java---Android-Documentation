package com.multidynamika.javabasic.classes;

public class BaseResponse<T> {

    public int code;
    public String message = "";
    public String error = "";
    public boolean status;
    public T data;

    public static <T extends Comparable<T>> T max(T a, T b) {
        T max = a;

        if (b.compareTo(a) > 0) {
            max = b;
        }

        return max;
    }

    public static void main(String[] args) {
        Integer max = max(1, 2);
        String large = max("a", "b");

        System.out.println(max + " , " + large);
    }
}
