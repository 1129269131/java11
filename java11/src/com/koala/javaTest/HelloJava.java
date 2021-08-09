package com.koala.javaTest;

/**
 * day07：更简单的编译运行程序
 * 测试：
 *   1、cmd打开该文件所处的目录
 *   2、执行：java HelloJava.java
 * Create by koala on 2021-08-08
 */
public class HelloJava {

    public static void main(String[] args) {
        System.out.println("Hello Java Simple");
        Teacher t = new Teacher();
    }

}

class Test2 {

    public static void main(String[] args) {
        System.out.println("Test2. main");
    }

}

class Teacher {

    private String name;
    private int age;

}
