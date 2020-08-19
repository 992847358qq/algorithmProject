package juc;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/7/8 22:58
 **/
public class NoVisibility {
    private static boolean ready;
    private static int number ;

     static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                System.out.println("----");
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        /*try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("****");
        number = 42;
        ready = true;
    }
}
