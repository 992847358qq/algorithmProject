package single;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:39 PM
 **/
public class LazyStaticSingleton {
    public LazyStaticSingleton(){

    }
    public static LazyStaticSingleton getInstance(){
        return LazyHolder.LAZY_STATIC_SINGLETON;
    }

    private static class LazyHolder{
        private static final LazyStaticSingleton LAZY_STATIC_SINGLETON = new LazyStaticSingleton();
    }
}
