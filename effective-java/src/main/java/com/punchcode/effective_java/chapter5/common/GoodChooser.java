package com.punchcode.effective_java.chapter5.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * List-based Chooser - typesafe
 * @author huanruiz
 * @since 2021/12/15
 */
public class GoodChooser<T> {

    /**
     * 这里如果用array, 就没法用T这个泛型, 因为T是可变类型. 虽然可以在Chooser例子中的构造器
     * {@code choiceArray = (T[]) choices.toArray();}加上强制类型转换, 但是会有unchecked cast的warning
     * 所以最好的方法还是用泛型
     */
    private final List<T> choiceList;

    public GoodChooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
