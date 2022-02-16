package com.punchcode.java_concurrency_in_practice.chapter4;

import com.punchcode.java_concurrency_in_practice.chapter4.common.Point;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author huanruiz
 * @since 2022/2/15
 */
public class DelegatingVehicleTracker {

    /**
     * Point is immutable, 线程安全
     */
    private final ConcurrentMap<String, Point> locations;

    /**
     * unmodifiableMap is immutable
     */
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        // unmodifiableMap是locations的有个view, 虽然可以实时更新, 但可能存在不一致的view, 因为view会跟着locations变.
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
        // 返回浅拷贝, 因为value不可变, 所以只需要赋值结构即可. 这样保证复制过来的view不发生变化.
        // return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
