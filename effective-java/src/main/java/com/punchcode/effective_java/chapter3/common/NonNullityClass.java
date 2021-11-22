package com.punchcode.effective_java.chapter3.common;

/**
 * @author huanruiz
 * @since 2021/11/19
 */
public class NonNullityClass {

    /**
     * 这种检查没啥必要
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        // 如果o为null, 返回false
        if (!(o instanceof NonNullityClass)) {
            return false;
        }
        NonNullityClass nnc = (NonNullityClass)o;
        return true;
    }
}
