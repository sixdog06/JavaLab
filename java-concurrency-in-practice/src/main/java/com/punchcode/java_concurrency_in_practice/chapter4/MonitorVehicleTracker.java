package com.punchcode.java_concurrency_in_practice.chapter4;

import com.punchcode.java_concurrency_in_practice.chapter4.common.MutablePoint;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 车辆追踪器, 监视器模式, 保证在修改MutablePoint时线程安全
 * @author huanruiz
 * @since 2022/2/14
 */
public class MonitorVehicleTracker {

    /**
     * 坐标, 这个locations和MutablePoint都不会publish
     */
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy( Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>(5);
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}
