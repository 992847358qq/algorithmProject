import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MR.Wang
 * @dept AbortPolicy 拒绝策略，超出最大线程数抛出异常,RejectedExecutionException
 * CallerRunsPolicy 超过最大核心线程，主线程执行，不会抛出异常
 * DiscardPolicy 队列满了,丢掉任务， 不会抛出异常
 * DiscardOldestPolicy 队列满了， 尝试和早进来的竞争，不会抛出异常
 * @description TODO
 * @date 2020/12/16 21:23
 **/
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i <= 15; i++) {
                final int temp = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+":"+temp);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

}
