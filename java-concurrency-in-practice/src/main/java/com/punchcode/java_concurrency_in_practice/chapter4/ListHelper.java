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
    
    /**
     * synchronized如果加载方法上, 锁就是ListHelper的实例, 和list中其他方法的锁不一样了, 无法保证线程安全
     */
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
