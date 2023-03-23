package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/7 10:27 PM
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，限制线程数
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
