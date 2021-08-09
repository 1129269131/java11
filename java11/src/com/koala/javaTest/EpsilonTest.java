package com.koala.javaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * day08：Epsilon垃圾收集器
 * 测试：
 *   1、下拉选择 Edit Configurations... --》 Modify options --》 Add VM options
 *   2、输入：-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
 *   3、未执行第二步时运行EpsilonTest.java 进行测试查看
 *   4、执行第二步后运行EpsilonTest.java 进行测试查看
 * Create by koala on 2021-08-08
 */
public class EpsilonTest {

    // 执行: -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
    public static void main(String[] args) {
        List<Garbage> list = new ArrayList<>();
        boolean flag = true;
        int count = 0;
        while (flag) {
            list.add(new Garbage());
            if (count++ == 500) {
                list.clear();
            }
        }
    }

}

class Garbage {

    private double d1 = 1;
    private double d2 = 2;

    // 这个方法是GC在清除本对象时, 会调用一次
    @Override
    public void finalize() {
        System.out.println(this + " collecting");
    }
}
