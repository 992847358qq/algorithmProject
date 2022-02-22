/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022-02-07
 **/
public class SingletonDemo {
    public static volatile SingletonDemo instance = null;

    public SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t  我是构造方法SingletonDemo() ");
    }

    public static synchronized SingletonDemo getInstance(){
        if(instance == null){
            //同步代码块  加锁前后判断
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
