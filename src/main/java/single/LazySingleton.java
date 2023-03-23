package single;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:14 PM
 **/
public class LazySingleton {
    public static LazySingleton lazySingleton = null;
    public LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
