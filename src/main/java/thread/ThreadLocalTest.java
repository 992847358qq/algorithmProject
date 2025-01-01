package thread;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/17 6:05 PM
 **/
public class ThreadLocalTest {
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        test.threadLocal.set("aaa");
        System.out.println(test.threadLocal.get());
        test.threadLocal.remove();
        System.out.println(test.threadLocal.get());
    }
}
