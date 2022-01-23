package com.punchcode.effective_java.chapter9;

import java.math.BigDecimal;

/**
 * Item 60: Avoid float and double if exact answers
 * @author huanruiz
 * @since 2022/1/23
 */
public class Item60 {

    public static void main(String[] args) {
        // 浮点型算不准
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);

        // 用BigDecimal
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        itemsBought = 0;
        BigDecimal funds2 = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds2.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds2 = funds2.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds2);

        // 降低单位粒度, 改为整型计算
        itemsBought = 0;
        int funds3 = 100;
        for (int price = 10; funds3 >= price; price += 10) {
            funds3 -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Cash left over: " + funds3 + " cents");
    }
}
