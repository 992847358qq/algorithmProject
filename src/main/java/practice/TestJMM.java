package practice;

import java.util.concurrent.TimeUnit;

/**
 * @author MR.Wang
 * @dept  线程操作在自己的内存区域中，线程之间的内存区域是无法互相访问的，大家都是通过堆中的共享内存来进行通信的
 * 如下面代码所示，A线程修改了number值，但对于Main线程是不可见的，所以main线程处于while死循环中
 * 如果线程实现可见性，变量需要由volatile修饰。
 * @description TODO
 * @date 2020/6/27 1:07
 **/
public class TestJMM {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(()->{
            System.out.println("************change start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.changeNumber();
            System.out.println(Thread.currentThread().getName()+"\t number value: "+myNumber.number);
        },"A").start();

        while (myNumber.number == 10){

        }
        System.out.println(Thread.currentThread().getName()+"\t number value: "+myNumber.number);
    }
}

class MyNumber{
    volatile int number = 10;
    public void changeNumber(){
        this.number = 1024;
    }
}
