package practice;

import java.util.concurrent.CompletableFuture;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/30 23:32
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" no ok---------");
        });
        completableFuture.get();
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"  ok---------------");
            int a = 100/0;
            return 1024;
        });
        System.out.println(completableFuture1.whenComplete((t, u) -> {
            System.out.println("*****t: " + t);
            System.out.println("*****u: " + u);
        }).exceptionally(f -> {
            System.out.println("----exception: " + f.getMessage());
            return 444;
        }).get());
    }
}
