package practice;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wgl
 * @Date: 2020/06/28 11:50
 * @Description:
 */
public class LimitPractice {
    // 限流的个数
    private static int maxCount = 10;
    // 指定的时间内
    private static long interval = 60;
    // 原子类计数器
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    // 起始时间
    private long startTime = System.currentTimeMillis();

    public boolean limit(int maxCount, long interval) {
        if (atomicInteger.get() == 0) {
            startTime = System.currentTimeMillis();
            atomicInteger.addAndGet(1);
            return true;
        }
        atomicInteger.addAndGet(1);
        // 超过了间隔时间，直接重新开始计数
        if (System.currentTimeMillis() - startTime > interval * 1000) {
            startTime = System.currentTimeMillis();
            atomicInteger.set(0);
            return true;
        }
        // 还在间隔时间内,check有没有超过限流的个数
        if (atomicInteger.get() > maxCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LimitPractice limitPractice = new LimitPractice();
        new Thread(()->{
            for (int i =1;i<20;i++){
                System.out.println(Thread.currentThread().getName()+i+limitPractice.limit(maxCount,interval));
                /*try {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        },"A").start();
    }
}
