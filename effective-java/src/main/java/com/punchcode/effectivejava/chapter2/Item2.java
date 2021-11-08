package com.punchcode.effectivejava.chapter2;

import com.punchcode.effectivejava.chapter2.common.Calzone;
import com.punchcode.effectivejava.chapter2.common.NutritionFacts;
import com.punchcode.effectivejava.chapter2.common.NyPizza;

import static com.punchcode.effectivejava.chapter2.common.NyPizza.Size.SMALL;
import static com.punchcode.effectivejava.chapter2.common.Pizza.Topping.*;

/**
 * Consider a builder when faced with many constructor parameters
 * @author huanruiz
 * @since 2021/11/8
 */
public class Item2 {
    public static void main(String[] args) {
        // 用builder就可以这样创建一个类, 这个NutritionFacts是immutable的
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);

        // Pizza
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
