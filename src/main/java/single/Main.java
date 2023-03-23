package single;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:11 PM
 **/
public class Main {
    public static void main(String[] args) {
        HungrySingleton h1 = HungrySingleton.getInstance();
        HungrySingleton h2 = HungrySingleton.getInstance();
        System.out.println(h1 == h2);

        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l1 == l2);

        SyncSingleton s1 = SyncSingleton.getInstance();
        SyncSingleton s2 = SyncSingleton.getInstance();
        System.out.println(s1==s2);

        LazyStaticSingleton ls1 = LazyStaticSingleton.getInstance();
        LazyStaticSingleton ls2 = LazyStaticSingleton.getInstance();
        System.out.println(ls1 == ls2);
    }
}
