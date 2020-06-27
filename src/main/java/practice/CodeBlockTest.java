package practice;

/**
 * @author MR.Wang
 * @dept  静态代码块 代码块 构造方法执行顺序  静态模板只加载一次
 * @description TODO
 * @date 2020/6/27 13:57
 **/
public class CodeBlockTest {
    public CodeBlockTest(){
        System.out.println("CodeBlockTest的构造方法");
    }
    {
        System.out.println("CodeBlockTest的代码块");
    }
    static {
        System.out.println("CodeBlockTest的静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("main入口");
        new myBlock();
        System.out.println("---------------------");
        new myBlock();
        System.out.println("---------------------");
        new CodeBlockTest();
    }
}
class myBlock{
    public myBlock(){
        System.out.println("myBock的构造方法");
    }
    {
        System.out.println("myBock的代码块");
    }
    static {
        System.out.println("myBock的静待代码块");
    }
}
