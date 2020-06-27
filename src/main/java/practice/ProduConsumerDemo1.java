package practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/18 23:09
 * 题目：现在两个线程，可以操作初始值为零的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替，来10轮，变量初始值为零
 * 1 高聚低合前提下，线程操作资源类
 * 2 判断/干活/通知
 * 3 防止多线程虚假唤醒
 **/
public class ProduConsumerDemo1 {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        /*new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();*/
    }
}
class AirCondition{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();
    public  void increment() throws Exception{
        lock.lock();
        try {
            while (number !=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public  void decrement() throws Exception{
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
