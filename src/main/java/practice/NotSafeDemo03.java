package practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/18 13:42
 * 1 故障现象
 *  java.util.ConcurrentModificationException
 * 2 导致原因
 *      并发增强同一个类没有加锁
 * 3 解决方法
 *  1.new Vector<>
 *  2.Collections.synchronizedList(new ArrayList<>())
 *  3.new CopyOnWriteArrayList<>();
 * 4 优化建议
 **/
public class NotSafeDemo03 {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        /*for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }*/
        listNotSafe();
    }

    private static void listNotSafe() {
        //List<String> list = new CopyOnWriteArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    private static void SetNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        //List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
