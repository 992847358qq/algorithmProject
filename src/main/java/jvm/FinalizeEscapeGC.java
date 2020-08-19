package jvm;

/**
 * @author MR.Wang
 * @dept  1、对象可以在被GC时自我拯救
 *  2、这种自救的方式只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 *  对象调用finalize方法在被收集前成功逃脱，但任何一个对象的finalize方法只能被系统自动
 *  调用一次，所以在面临下一次回收，finalize方法不会被执行，因此第二次自救行动失败
  @description TODO
 * @date 2020/7/19 20:53
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes,i am still alive:)");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , i am dead :(");
        }
        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no , i am dead :(");
        }
    }

}
