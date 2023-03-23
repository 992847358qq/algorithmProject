package test;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/30 10:00 PM
 **/
public class Test {

     void test(){
         System.out.println("default级别修饰的方法");
    }

    public void test1(){
        System.out.println("public级别修饰的方法");
    }

    protected void test2(){
        System.out.println("protected级别修饰的方法");
    }

    private void test3(){
        System.out.println("private级别修饰的方法");
    }
}
