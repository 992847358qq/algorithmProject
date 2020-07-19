package practice;

import java.util.concurrent.*;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/29 17:00
 **/
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                        2,
                         Runtime.getRuntime().availableProcessors(), //cpu处理器几核，最大线程数=核数+1
                        2L,
                        TimeUnit.SECONDS,
                         new LinkedBlockingDeque<>(3),
                        Executors.defaultThreadFactory(),
                         new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void initPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一个池子5个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一个池子1个线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一个池子N个线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
