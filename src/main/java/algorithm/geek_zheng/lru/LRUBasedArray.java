package algorithm.geek_zheng.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/11/12 11:51 AM
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 **/
public class LRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int defaultCapacity) {
        capacity = defaultCapacity;
        count = 0;
        value = (T[])new Object[defaultCapacity];
        holder = new HashMap<T,Integer>(defaultCapacity);
    }

    /**
     * 模拟访问某个值
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     * @param end
     */
    private void update(Integer end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target,0);
    }

    /**
     * end左边的数据统一右移一位
     * @param end
     */
    private void rightShift(Integer end) {
        for (int i = end-1; i >=0 ; i--) {
            value[i+1] = value[i];
            holder.put(value[i],i+1);
        }

    }
    /**
     * 缓存数据到头部，但要先右移
     * @param object
     * @param end 数组右移的边界
     */
    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object,0);
        count++;
    }

    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object,count);
    }

    private boolean isFull() {

     return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            //testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
