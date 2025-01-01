package test;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/30 10:04 PM
 **/
public class Test1 {
    //同包情况下，可以访问default、protect、public修饰的方法
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
        test.test1();
        test.test2();
    }
}
