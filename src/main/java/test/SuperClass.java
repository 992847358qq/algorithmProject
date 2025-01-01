package test;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/10 7:09 PM
 **/
public class SuperClass {
    static {
        System.out.println("superclass init");
    }
    public static int value = 123;

    public static void staticMethod(){
        System.out.println("this is a static method");
    }

    public void commonMethod(){
        System.out.println("this is not a static method");
    }


}
