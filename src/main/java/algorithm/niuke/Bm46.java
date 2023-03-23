package algorithm.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @description: 最小的k个数
 * 最小堆求前k大，最大堆求前k小
 * @author: gaoliang.wang
 * @date: 2022/4/23 11:24 PM
 **/
public class Bm46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || k ==0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1,e2)->e2 - e1);
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size()<k){
                maxHeap.offer(input[i]);
            }else {
                if (input[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        return result;
    }
}
