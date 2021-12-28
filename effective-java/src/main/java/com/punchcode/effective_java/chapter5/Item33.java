package com.punchcode.effective_java.chapter5;

import com.punchcode.effective_java.chapter5.common.Favorites;

/**
 * Item 33: Consider typesafe heterogeneous containers
 * @author huanruiz
 * @since 2021/12/27
 */
public class Item33 {

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
