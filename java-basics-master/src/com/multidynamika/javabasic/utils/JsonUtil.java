package com.multidynamika.javabasic.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class JsonUtil {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T toObject(String json, Class<T> type) {
        return new Gson().fromJson(json, type);
    }

    public static <T> List<T> toList(String json, Class<T> type) {
        return new Gson().fromJson(json, new TypeToken<T>(){}.getType());
    }
}
