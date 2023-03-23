package algorithm.swordToOffer2.heap;

import java.util.PriorityQueue;

/**
 * @description: 数据流的第k个大数字
 * @author: gaoliang.wang
 * @date: 2022/3/5 10:34 PM
 **/
public class No59 {
    //空间复杂度O(k)，时间复杂度O(logk)
    private PriorityQueue<Integer> minHeap;
    private int size;
    public No59(int k,int[] nums){
        this.size = k;
        for (int num:nums){
            add(num);
        }
    }
    public int add(int num){
        if (minHeap.size()<size){
            minHeap.add(num);
        }else {
            if (num>minHeap.peek()){
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }
}
