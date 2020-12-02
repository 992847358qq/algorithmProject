package thread;


import org.apache.commons.lang3.time.StopWatch;

/**
 * @Author: wgl
 * @Date: 2020/08/19 17:16
 * @Description:
 */
public class CarDemo {
    private static String body;
    private static  String wheels;
    public static void main(String[] args) throws InterruptedException {
        carTest();

    }
    private static void carTest() throws InterruptedException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int n = 4;
        for (int i = 0; i < 4; i++) {
            Thread t1=new Thread(()->{
                body=madeBody();
                System.out.println(body);
            });
            Thread t2=new Thread(()->{
                wheels=madeWheels();
                System.out.println(wheels);
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String car=madeCar(body,wheels);
            System.out.println(car);
            //单线程
            /*System.out.println("开始制造");
            String body = madeBody();
            System.out.println(body);
            String wheels = madeWheels();
            System.out.println(wheels);
            System.out.println("开始组装");
            String car = madeCar(body, wheels);
            System.out.println(car);*/
        }
        stopWatch.stop();
        System.out.println("制造"+n+"台汽车耗时"+stopWatch.getTime()+"秒");
    }



    private static String madeBody(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "车身";
    }

    private static String madeWheels(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "轮子";
    }

    private static String madeCar(String body,String wheels){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return body+wheels;
    }
}
