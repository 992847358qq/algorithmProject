import javax.swing.plaf.metal.MetalBorders;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/12/16 0:15
 **/
public class Test {
    public static void main(String[] args) {
        shareData shareData = new shareData();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareData.printData(1);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareData.printData(2);
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                shareData.printData(3);
            }
        },"C").start();
    }

    static class shareData{
        private int number = 1;
        private Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        public void printData(int value) {
            try {
                lock.lock();
                switch (value){
                    case 1:
                        while (number != 1){
                            System.out.println("c1");
                            c1.await();
                        }
                        for (int i = 0; i < 1; i++) {
                            System.out.println(Thread.currentThread().getName()+"--"+i);
                        }
                        number = 2;
                        //唤醒一个c2运行
                        c2.signal();
                        break;
                    case 2:
                        while (number != 2){
                            System.out.println("c2");
                            c2.await();
                        }
                        for (int i = 0; i < 2; i++) {
                            System.out.println(Thread.currentThread().getName()+"--"+i);
                        }
                        number = 3;
                        //唤醒一个c2运行
                        c3.signal();
                        break;
                    case 3:
                        while (number != 3){
                            System.out.println("c3");
                            c3.await();
                        }
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName()+"--"+i);
                        }
                        number = 1;
                        //唤醒一个c2运行
                        c1.signal();
                        break;
                    default:
                        break;
                }
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }
}
