package com.punchcode.java_concurrency_in_practice.chapter3;

import com.punchcode.java_concurrency_in_practice.chapter3.common.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author huanruiz
 * @since 2022/2/9
 */
public class ThreadConfinementExample {

    private static final String DB_URL = "haha.com";

    /**
     * animals作为局部变量, 被封闭在栈内
     */
    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animals confined to method, don’t let them escape!
        animals = new TreeSet<>();
        animals.addAll(candidates);
        for (Animal a : animals) {
            if (candidate == null || !candidate.isPotentialMate(a)) {
                candidate = a;
            }
        }
        return numPairs;
    }

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {

        @Override
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
