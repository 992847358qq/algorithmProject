package base.reflect;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023-09-12
 **/
public class ReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ReflectObj reflectObj = ReflectObj.class.newInstance();
        reflectObj.toString();
    }
}
