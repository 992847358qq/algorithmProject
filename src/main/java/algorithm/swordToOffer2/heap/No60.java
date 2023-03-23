package algorithm.swordToOffer2.heap;

import java.util.*;

/**
 * @description: 出现频率最高的k个数字
 * @author: gaoliang.wang
 * @date: 2022/3/5 10:35 PM
 **/
public class No60 {
    //需要一个大小为O(n)的哈希表和大小为O(k)的最小堆，所以空间复杂度为O(n)
    //最小堆添加、删除元素时间复杂度为O(logn);
    public List<Integer> topN(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (e1,e2)->e1.getValue() - e2.getValue());
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (queue.size()<k){
                queue.add(entry);
            }else {
                if (entry.getValue() > queue.peek().getValue()){
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:queue){
            result.add(entry.getKey());
        }
        return result;
    }
}
