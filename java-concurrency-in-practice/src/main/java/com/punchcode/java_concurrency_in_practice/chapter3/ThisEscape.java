package com.punchcode.java_concurrency_in_practice.chapter3;

import com.punchcode.java_concurrency_in_practice.chapter3.common.Event;
import com.punchcode.java_concurrency_in_practice.chapter3.common.EventSource;
import com.punchcode.java_concurrency_in_practice.chapter3.common.EventListener;

/**
 * this溢出
 * @author huanruiz
 * @since 2022/2/9
 */
public class ThisEscape {

    /**
     * 构造函数中, 包含对this的隐式引用, 所以当ThisEscape构造器发布EventListener时, this也会被发布.
     */
    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {
                    @Override
                    public void onEvent(Event e) {
                        // 这个时候this溢出了
                        System.out.println(this);
                    }
                }
        );
        System.out.println("do other thing");
    }

    public static void main(String[] args) {
        EventSource source = new EventSource();
        new ThisEscape(source);
        source.eventListener.onEvent(new Event());
    }
}
