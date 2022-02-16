package com.punchcode.java_concurrency_in_practice.chapter4;

import com.punchcode.java_concurrency_in_practice.chapter4.common.SafePoint;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SafePoint被发布的版本, SafePoint本身线程安全, 所以可以可变. 可以改变车辆的位置.
 * @author huanruiz
 * @since 2022/2/16
 */
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;

    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
        locations.get(id).set(x, y);
    }
}
