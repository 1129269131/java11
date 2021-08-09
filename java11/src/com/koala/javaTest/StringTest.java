package com.koala.javaTest;

import org.junit.Test;

import java.io.FileInputStream;

/**
 * day04：字符串和Optional的新API
 * Create by koala on 2021-08-08
 */
public class StringTest {

    @Test
    public void testName1() throws Exception {
        String string = " \t  \r\n ";
        System.out.println(string.isBlank()); // 判断字符串中的字符是否都是空白

        System.out.println("**************************");

        string = " \t  \r\n abc \t　";
        String string2 = string.strip(); // 去掉字符串首尾的空白, 包括英文和其他所有语言中的空白字符
        System.out.println(string2);
        System.out.println(string2.length());

        String string3 = string.trim(); // 去掉字符串首尾的空白字符, 只能去除码值小于等于32的空白字符
        System.out.println(string3);
        System.out.println(string3.length());

        System.out.println("**************************");

        String string4 = string.stripLeading(); // 去掉字符串首部的空白
        System.out.println(string4);
        System.out.println(string4.length());

        String string5 = string.stripTrailing(); // 去掉字符串尾部的空白
        System.out.println(string5);
        System.out.println(string5.length());
    }

    @Test
    public void testName2() throws Exception {
        String string = "Java";
        String string2 = string.repeat(5);
        System.out.println(string2);
    }

    @Test
    public void testName3() throws Exception {
        FileInputStream fis = new FileInputStream("src/com/koala/javaTest/StringTest.java");
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        String string = new String(buffer);

        string.lines().forEach(System.out::println);
    }

}
