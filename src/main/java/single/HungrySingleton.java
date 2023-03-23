package single;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:11 PM
 **/
public class HungrySingleton {
    public static HungrySingleton hungrySingleton;
    public HungrySingleton(){

    }
    static {
        hungrySingleton = new HungrySingleton();
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
