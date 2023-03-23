package lock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:29 PM
 **/
public class LockTest1 {
    public static void main(String[] args) {
        Phone4 p4= new Phone4();

        new Thread(()->{
            p4.SendSms();
        },"A").start();

        //捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            p4.call();
        },"B").start();
    }
}

class Phone4{
    public static synchronized void SendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    //普通锁
    public synchronized void call(){
        System.out.println("打电话");
    }

}
