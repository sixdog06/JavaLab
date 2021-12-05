package com.punchcode.effective_java.chapter4.common;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author huanruiz
 * @since 2021/12/3
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    /**
     * 保存总共添加的数量
     */
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }/**/

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    /**
     * 会导致bug, 因为{@code super.addAll(c)}中调用了add. 去掉后即可. 或者不用HashSet的addAll, 而是
     * 自己全部重写, 但这样让代码脆弱.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
