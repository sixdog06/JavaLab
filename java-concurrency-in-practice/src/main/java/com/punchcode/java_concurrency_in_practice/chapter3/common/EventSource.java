package com.punchcode.java_concurrency_in_practice.chapter3.common;


/**
 * @author huanruiz
 * @since 2022/2/9
 */
public class EventSource {

    public EventListener eventListener;

    public void registerListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
