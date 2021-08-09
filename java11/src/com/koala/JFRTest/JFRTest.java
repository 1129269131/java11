package com.koala.JFRTest;

import java.util.ArrayList;
import java.util.List;

/**
 * day09：FightRecorder
 * 测试：
 *   1、cmd打开该文件所处的目录
 *   2、执行：javac JFRTest.java
 *   3、执行：java JFRTest
 *   4、此时程序已经运行
 *   5、再次cmd打开该文件所处的目录，打开第二个命令提示符弹框，开始执行JFR记录
 *   6、执行如下命令（pid可查找任务管理器中的进程 java.exe 所在的 PID值）：
 *      $ jcmd <pid> JFR.start
 *      $ jcmd <pid> JFR.dump filename=recording.jfr name=1
 *      $ jcmd <pid> JFR.stop
 *   7、查看jft的使用案例（jdk版本12及之后）
 *      执行：jft
 *   8、解析查看生成的.jfr文件的概况信息（jdk版本12及之后）
 *      执行：jfr summary recording.jfr
 * Create by koala on 2021-08-08
 */
public class JFRTest {

    public static void main(String[] args) {
        List<Garbage> list = new ArrayList<>();
        boolean flag = true;
        int count = 0;
        while (flag) {
            list.add(new Garbage());
            if (count++ == 20) {
                list.clear();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
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