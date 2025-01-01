package algorithm.swordToOffer2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 累加数组数字求子数组之和
 * 和为k的子数组
 * @author: gaoliang.wang
 * @date: 2022-02-12
 **/
public class No10 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,3,2,6,1,4,1};
        System.out.println(subArraySum(nums,5));
    }
    public static int subArraySum(int[] nums,int k){
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num:nums){
            sum+=num;
            count+=sumToCount.getOrDefault(sum-k,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0) +1);
        }
        return count;
    }
}
