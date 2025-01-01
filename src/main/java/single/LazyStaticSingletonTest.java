package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:42 PM
 **/
public class LazyStaticSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = LazyStaticSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Object obj = constructor.newInstance();

        Object instance = LazyStaticSingleton.getInstance();

        System.out.println(obj == instance);

    }
}
