package com.punchcode.java_concurrency_in_practice.chapter4;

import com.punchcode.java_concurrency_in_practice.chapter4.common.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huanruiz
 * @since 2022/2/14
 */
public class PersonSet {

    /**
     * HashSet不是线程安全, 但是访问的方法线程安全, 保证了mySet线程安全
     * 注意这里的Person的线程安全性没有做假设
     */
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }
    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
