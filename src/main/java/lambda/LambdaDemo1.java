package lambda;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/18 11:18
 **/
public class LambdaDemo1 {
    public static void main(String[] args) {
        /*Foo foo = new Foo(){

            @Override
            public void sayHello() {
                System.out.println("hello world");
            }
        };
        foo.sayHello();*/
        Foo foo = (int x,int y)->{
            System.out.println("相加总和：");
            return x+y;
        };
        System.out.println(foo.add(1, 2));
    }
}
@FunctionalInterface
interface Foo{
    //public void sayHello();
    public int add(int a,int b);
    public default int mul(int x,int y){
        return  x*y;
    }
}
