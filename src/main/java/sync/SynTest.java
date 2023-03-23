package sync;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/16 10:46 PM
 **/
public class SynTest {


    public synchronized void testA(){
        System.out.println("这是A方法");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void testB(){
        System.out.println("这是B方法");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
