package com.punchcode.effective_java.chapter7;

import com.punchcode.effective_java.chapter7.common.PowerSet;
import com.punchcode.effective_java.chapter7.common.SubLists;

import java.util.Arrays;

/**
 * Item 47: Prefer Collection to Stream as a return type
 * @author huanruiz
 * @since 2022/1/16
 */
public class Item47 {

    public static void main(String[] args) {
        // 无法编译, 需要通过(Iterable<ProcessHandle>)强制转换类型, 或iterableOf(ProcessHandle.allProcesses())
        // for (ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
        //     // Process the process
        // }

        /**
         * 因为size的限制, Collection最大支持Integer.MAX_VALUE(这一点不完全对, 具体还是看实现),
         *  但是size最大只能返回Integer.MAX_VALUE
         */
        PowerSet powerSet = new PowerSet();

        // List转换stream
        SubLists.of(Arrays.asList(1, 2, 3));
    }
}
