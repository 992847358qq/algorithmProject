package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022-02-06
 **/
public class MyObjct {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    int count = 0;
    public  void incr(){
        //count++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        MyObjct myObjct = new MyObjct();
//        new Thread(()->{
//            for (int i = 0; i < 20000; i++) {
//                myObjct.incr();
//            }
//        }).start();
//        new Thread(()->{
//            for (int i = 0; i < 20000; i++) {
//                myObjct.incr();
//            }
//        }).start();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(myObjct.count);

        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                myObjct.incr();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                myObjct.incr();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(myObjct.atomicInteger.get());
    }
}
