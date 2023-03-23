package sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/10 10:26 PM
 **/
public class Main {
    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        new Thread(()->{
            synTest.testA();

        }).start();
        new Thread(()->{
            synTest.testB();

        }).start();
    }
}
