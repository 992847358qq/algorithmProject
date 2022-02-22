import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022-02-05
 **/
public class Test {
    public static void main(String[] args) {
//       new Thread(()->{
//           System.out.println("A");
//           synchronized (Test.class){
//               System.out.println("A1");
//               try {
//                   TimeUnit.SECONDS.sleep(1);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           }
//       }).start();
//       new Thread(()->{
//           System.out.println("B");
//           synchronized (Test.class){
//               System.out.println("B1");
//               try {
//                   TimeUnit.SECONDS.sleep(1);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//
//           }
//       }).start();
        synchronized (Test.class){

        }
        new Test().method();
    }

    public  void method(){

    }
}
