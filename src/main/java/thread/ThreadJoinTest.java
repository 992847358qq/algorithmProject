package thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: wgl
 * @Date: 2020/08/19 15:59
 * @Description:
 */
public class ThreadJoinTest {
    private static final Object obj = new Object();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1,2,0L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(124),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(3);
        singleThreadPool.execute(()->{
            synchronized (obj){
                System.out.println("Thread1 start1");
                for (int i = 0; i < 10; i++) {
                    count++;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 end1");
                countDownLatch.countDown();
            }
        });
        singleThreadPool.execute(()->{
            synchronized (obj){
                System.out.println("Thread1 start2");
                for (int i = 0; i < 10; i++) {
                    count++;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 end2");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await(5,TimeUnit.SECONDS);
        singleThreadPool.shutdown();
        System.out.println("count:"+count);


























       /*Thread t1 = new Thread(()->{
            synchronized (obj){
                System.out.println("Thread1 start");
                for (int i = 0; i < 10; i++) {
                    count++;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 end");
            }
        },"myThread1");
        Thread t2 = new Thread(()->{
            synchronized (obj){
                System.out.println("Thread2 start");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    count++;
                }
                System.out.println("Thread2 end");
            }
        },"myThread2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);*/
    }


}
