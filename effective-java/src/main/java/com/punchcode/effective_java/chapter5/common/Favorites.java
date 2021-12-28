package com.punchcode.effective_java.chapter5.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author huanruiz
 * @since 2021/12/28
 */
public class Favorites {

    /**
     * {@code Class<?>}是key, 可以传入不同的泛型. 但是不能传入类似{@code List<String>}的对象, 只能传Java Object
     *
     */
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    /**
     * 转换element到annotationTypeName对应Class的子类
     */
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        // Unbounded type token
        Class<?> annotationType;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}