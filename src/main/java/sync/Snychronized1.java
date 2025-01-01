package sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/10 10:28 PM
 **/
public class Snychronized1 {
    public static class A {
    }
    public static void main(String[] args) throws Exception {
        A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        System.out.println("**** 对象创建,没有经过锁竞争");
        System.out.println(layout.toPrintable());
        synchronized (a) {
            System.out.println("**** 获取到锁");
            System.out.println(layout.toPrintable());
        }
        System.out.println("**** 锁释放");
        System.out.println(layout.toPrintable());
    }
}
