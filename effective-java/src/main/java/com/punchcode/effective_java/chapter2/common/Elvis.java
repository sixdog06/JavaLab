package com.punchcode.effective_java.chapter2.common;

/**
 * @author huanruiz
 * @since 2021/11/9
 * todo: supplier, Serializable example
 */
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();
    //private static final Elvis INSTANCE = new Elvis();

    /**
     * 构造器私有化
     */
    private Elvis() {

    }

    /**
     * 用静态工厂方法返回instance, 可以把INSTANCE改为private
     * @return INSTANCE
     */
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }
}
