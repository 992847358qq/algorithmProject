package single;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/18 10:15 PM
 **/
public class SyncSingleton {
    public static volatile SyncSingleton syncSingleton;
    public SyncSingleton(){

    }
    public static SyncSingleton getInstance(){
        if (syncSingleton == null){
            synchronized (SyncSingleton.class){
                if (syncSingleton == null){
                    syncSingleton = new SyncSingleton();
                }
            }
        }
        return syncSingleton;
    }
}
