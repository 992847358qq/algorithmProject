package thread;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/10 11:39 PM
 **/
public class ThreadTest {
    private static int count = 0;
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 1; i < 11; i++) {
                count+=1;
            }
        }).start();
    }
}
