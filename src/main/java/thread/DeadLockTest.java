package thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/8 10:30 PM
 **/
public class DeadLockTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(()->{
            synchronized (obj1){
                System.out.println("拿到obj1对象");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("拿到obj2对象");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (obj2){
                System.out.println("拿到obj2对象");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println("拿到obj1对象");
                }
            }
        }).start();
    }
}
