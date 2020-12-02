package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/11/15 22:51
 **/
public class JConsoleTest {

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i =0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();
    }
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
}


