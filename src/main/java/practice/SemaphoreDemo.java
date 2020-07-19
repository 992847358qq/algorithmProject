package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author MR.Wang
 * @dept  在信号量上定义两种操作，acquire（）获取，当一个线程调用acquire时，它要么成功获取到信号量（信号量减1）
 * 要么一直等待，直到有线程释放信号量，或超时
 * release释放，实际上将信号量值加1，然后唤醒等待的线程
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 * @description TODO
 * @date 2020/6/28 23:27
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟资源位，有三个空车位
        /*for (int i = 1; i <= 7; i++) {
            new Thread(()->{

            },String.valueOf(i)).start();
        }*/
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢占了车位");
                    //暂停一会线程
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
