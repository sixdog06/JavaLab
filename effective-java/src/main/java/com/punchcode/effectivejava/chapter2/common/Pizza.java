package com.punchcode.effectivejava.chapter2.common;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author huanruiz
 * @since 2021/11/8
 */
public abstract class Pizza {

    /**
     * 枚举类定义左右pizza通用的topping
     */
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    /**
     * 某个pizza要加的toppings
     */
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        // 初始化toppings
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // 可重复添加, 每次都会把self(this) return回去
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        // 返回最终的Pizza实例
        abstract Pizza build();

        /**
         * Subclasses must override this method to return "this"
         */
        protected abstract T self();
    }

    // 构造器需传入builder
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
