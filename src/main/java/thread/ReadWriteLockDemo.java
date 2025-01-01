package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/7 11:21 PM
 **/
public class ReadWriteLockDemo {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static volatile int value = 0;

    public static void readAmount() {
        readLock.lock();
        try {
            System.out.println("查看金额:" + value);
            try {
                // 模拟业务处理
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            readLock.unlock();
        }
    }

    public static void addAmount() {
        writeLock.lock();
        try {
            System.out.println("进入方法");
            try {
                // 模拟业务处理
                ++value;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("退出方法");
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> readAmount()).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(() -> addAmount()).start();
        }
    }
}
