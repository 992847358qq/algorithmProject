package practice;

import java.util.concurrent.TimeUnit;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/18 16:03
 * 1.标准访问，请问先打印邮件还是短信
 * 2.暂停4秒钟方法，请问先打印邮件还是短信
 * 3.新增普通sayHello方法，请问先打印邮件还是hello
 * 4.两部手机，先打印邮件还是短信
 * 5.两个静态同步方法，同一部手机，先打印邮件还是短信
 * 6.两个静态同步方法，两部手机，先打印邮件还是短信
 * 7.一个静态同步方法，一个普通同步方法，同一部手机，先打印邮件还是短信 静态同步方法和普通同步方法锁的对象不同
 * 普通同步方法锁的时调用者，静态同步锁的是class类模板
 * 8.一个静态同步方法，一个普通同步方法，两部手机，先打印邮件还是短信
 *
 *  一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，
 *  其它的线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 *
 *  锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他synchronized方法
 *
 *  加个普通方法后发现和同步锁无关
 *
 *  换成两个对象后，不是同一把锁了，情况立刻变化
 *  synchronized实现同步的基础：JAVA中的每一个对象都可以作为锁
 *  具体表现为以下3种形式
 *  对于普通同步方法，锁是当前实例对象this，调用方法的对象
 *  对于同步方法块，锁是synchronized括号里配置的对象
 *  对于静态同步方法，锁是当前类的class对象 （所以当我们new多个对象时，其实引用的统一个class对象）
*
 *  所有的静态同步方法用的也是同一把锁-类对象Class本身
 *  这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞争条件的
 *  但是一旦有一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁
 *  而不管是同一个实例对象的静态同步方法还是不同的实例对象的静态同步方法之间，
 *  只要他们是同一个类的实例对象
 **/
public class LockPractice {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            try {
                //phone.sendMessage();
                phone.sayHello();
                //phone1.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
class Phone{
    public   static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("******sendEmail");
    }
    public  static synchronized void sendMessage() throws Exception{
        System.out.println("******sendMessage");
    }
    public void sayHello() throws Exception{
        System.out.println("******sayHello");
    }
}
