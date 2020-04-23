package com.freedom.mybatis;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author tobebetter9527
 * @description TODO
 * @create 2020/04/18 16:24
 */
public class MyTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }, 10000);
    }
}
