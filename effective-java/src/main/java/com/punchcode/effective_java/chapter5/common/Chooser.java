package com.punchcode.effective_java.chapter5.common;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author huanruiz
 * @since 2021/12/15
 */
public class Chooser {

    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    /**
     * @return 返回后需要cast
     */
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}

