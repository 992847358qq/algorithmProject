package practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/30 22:24
 **/
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(1,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        System.out.println(submit.get());
        forkJoinPool.shutdown();

    }
}
class MyTask extends RecursiveTask<Integer>{
    private static final Integer value = 10;

    private int begin;
    private int end;
    private int result;

    public MyTask(int begin,int end){
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if ((end-begin) <=value){
            for (int i = begin; i <=end ; i++) {
                result = result+i;
            }
        }else {
            int middle = (end+begin)/2;
            MyTask task1 = new MyTask(begin,middle);
            MyTask task2 = new MyTask(middle+1,end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}