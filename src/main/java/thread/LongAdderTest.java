package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/5/28 1:06 PM
 **/
public class LongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (int j = 0; j < 5000; j++) {
                    longAdder.increment();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(longAdder.sum());
    }
}
