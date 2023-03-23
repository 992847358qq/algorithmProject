package test.test1;

import test.Test;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/30 10:04 PM
 **/
public class Test1 {
    public static void main(String[] args) {
//        Test test = new Test();
//        test.test1();
        Object obj = 1;
        Object obj1 = 1;
        Object obj2 = new Object();
        obj2 = 1;
        Object obj3 = new Object();
        obj3 = 2;
        System.out.println(obj == obj1);
        System.out.println(obj.equals(obj1));

        System.out.println(obj2 == obj3);
        System.out.println(obj2.equals(obj3));

        Integer i = 255;
        Integer i2 = 255;
        System.out.println(i == i2);
    }
}
