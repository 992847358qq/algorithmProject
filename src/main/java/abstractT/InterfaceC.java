package abstractT;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/3/8 22:20
 **/
public interface InterfaceC {
    // static修饰符定义静态方法
    static String staticMethod() {
        System.out.println("接口中的静态方法");
        return "A";
    }

    // default修饰符定义默认方法
    default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }
}
