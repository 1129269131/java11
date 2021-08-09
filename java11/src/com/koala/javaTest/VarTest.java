package com.koala.javaTest;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * day01：局部变量类型推断
 * Create by koala on 2021-08-08
 */
public class VarTest {

    //var s = "String";

    @Test
    public void test1() {
        var s = "String";
        System.out.println(s);
    }

    @Test
    public void test2() {
        Consumer<String> consumer1 = t -> System.out.println(t.toUpperCase());
        consumer1.accept("abcdEfg");

        Consumer<String> consumer2 = (var t) -> System.out.println(t.toUpperCase());
        consumer2.accept("abcdEfg");

        //错误的形式：必须要有类型, 可以加上var
        //Consumer<String> consumer3 = (@Deprecated t) -> System.out.println(t.toUpperCase());

        //正确的形式：
        Consumer<String> consumer4 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
        consumer4.accept("abcdEfg");
    }

}
