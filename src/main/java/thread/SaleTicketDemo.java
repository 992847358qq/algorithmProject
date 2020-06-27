package thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/17 22:56
 **/
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new  Thread(()->{for (int i = 0;i<=40;i++){ ticket.sale();}},"A").start();
        new  Thread(()->{for (int i = 0;i<=40;i++){ ticket.sale();}},"B").start();
        new  Thread(()->{for (int i = 0;i<=40;i++){ ticket.sale();}},"C").start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "B").start();*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "C").start();
    }

}
class Ticket{
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第： "+(number--)+"\t还剩下: "+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
