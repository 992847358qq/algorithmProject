package practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/20 21:04
 * 备注：多线程之间顺序调用，实现A->B->C
 * 三个线程启动，需求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 **/
public class ConditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //shareData.print5();
                shareData.myPrint(5);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //shareData.print10();
                shareData.myPrint(10);
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //shareData.print15();
                shareData.myPrint(15);
            }
        },"C").start();
    }
}
class  ShareData{
    private int number = 1; //A1 B2 C3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            //判断
            while (number != 1){
                c1.await();
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 2;
            //如何通知第二个
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                c2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 3;
            //如何通知第二个
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                c3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 1;
            //如何通知第二个
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void myPrint(int data){
        lock.lock();
        try {
            switch (data){
                case 5:
                    //判断
                    while (number != 1){
                        c1.await();
                    }
                    //干活
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName()+"\t"+i);
                    }
                    //通知
                    number = 2;
                    //如何通知第二个
                    c2.signal();
                    break;
                case 10:
                    //判断
                    while (number != 2){
                        c2.await();
                    }
                    //干活
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName()+"\t"+i);
                    }
                    //通知
                    number = 3;
                    //如何通知第三个
                    c3.signal();
                    break;
                case 15:
                    //判断
                    while (number != 3){
                        c3.await();
                    }
                    //干活
                    for (int i = 0; i < 15; i++) {
                        System.out.println(Thread.currentThread().getName()+"\t"+i);
                    }
                    //通知
                    number = 1;
                    //如何通知第一个
                    c1.signal();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
