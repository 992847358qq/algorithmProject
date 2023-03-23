package demo;

import com.google.common.collect.Maps;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/13 11:43 AM
 **/
public class ConcurrentHashMapDemo {
    private final ConcurrentMap<Integer, String> conHashMap = Maps.newConcurrentMap();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
            service.execute(demo.new WriteThreadOne());
            service.execute(demo.new WriteThreadTwo());
            service.execute(demo.new ReadThread());
        }finally {
            service.shutdown();
        }

    }

    class WriteThreadOne implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                conHashMap.putIfAbsent(i,"A"+i);
            }
        }
    }

    class WriteThreadTwo implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                conHashMap.putIfAbsent(i,"B"+i);
            }
        }
    }

    class ReadThread implements Runnable{

        @Override
        public void run() {
            for (Integer k:conHashMap.keySet()){
                System.out.println(k+":"+conHashMap.get(k));
            }
        }
    }


}
