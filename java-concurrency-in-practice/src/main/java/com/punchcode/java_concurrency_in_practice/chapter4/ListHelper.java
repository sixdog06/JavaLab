package com.punchcode.java_concurrency_in_practice.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huanruiz
 * @since 2022/2/16
 */
public class ListHelper {

    public List<String> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(String x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                // do something
                return true;
            }
            return false;
        }
    }
}
