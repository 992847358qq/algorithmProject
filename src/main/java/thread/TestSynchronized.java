package thread;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/10 3:58 PM
 **/
public class TestSynchronized {
    private Object obj = new Object();
    public void testLock() {
        synchronized (obj) {
            System.out.println("获取了锁");
        }
    }
}
