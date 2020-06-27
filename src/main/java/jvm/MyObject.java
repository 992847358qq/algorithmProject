package jvm;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/21 14:24
 **/
public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());//BootstrapClassLoader是C语言写的，在JAVA中得到的就是Null;

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@2503dbd3
        System.out.println(myObject.getClass().getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
