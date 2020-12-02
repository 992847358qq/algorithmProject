package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/11/15 23:18
 **/
public class Deadline {
    public static void createBusyThread(){
        Thread thread = new Thread(()->{
            for (int i =1;i<100;i++){
                System.out.println(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"createThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        Integer.valueOf(10);
    }

}
