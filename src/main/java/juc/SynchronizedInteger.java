package juc;

//import net.jcip.annotations.ThreadSafe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.TimeUnit;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/7/8 23:28
 **/
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this") private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            final int temp = i;
            new Thread(()->{
                SynchronizedInteger synchronizedInteger = new SynchronizedInteger();
                synchronizedInteger.setValue(temp);
                System.out.println(Thread.currentThread().getName()+"设置值为："+temp);
                System.out.println(Thread.currentThread().getName()+"得到值为："+synchronizedInteger.getValue());
            },String.valueOf(temp)).start();
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
