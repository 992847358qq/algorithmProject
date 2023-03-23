package algorithm.swordToOffer2.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @description: 值和下标之差都在给定的范围内
 * @author: gaoliang.wang
 * @date: 2022/3/2 10:58 PM
 **/
public class No57 {

    public boolean test(int[] nums,int k ,int t){
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long lower = set.floor((long)nums[i]);
            if (lower != null && lower >= nums[i] - t){
                return true;
            }
            Long higher = set.ceiling((long)nums[i]);
            if (higher != null && higher<= nums[i] + t){
                return true;
            }
            if (i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    //基于桶解决问题
    public boolean test1(int[] nums,int k , int t){
        Map<Integer,Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBuckerId(num,bucketSize);
            if (buckets.containsKey(id)
            || (buckets.containsKey(id-1) && buckets.get(id-1) >= num-t)
            || (buckets.containsKey(id+1) && buckets.get(id+1) <= num+t)){
                return true;
            }
            buckets.put(id,num);
            if (i>=k){
                buckets.remove(getBuckerId(nums[i-k],bucketSize));
            }
        }
        return false;
    }

    private int getBuckerId(int num, int bucketSize) {
        return num >=0? num/bucketSize:(num+1)/bucketSize-1;
    }
}
