package algorithm.swordToOffer2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 0和1个数相同的子数组
 * 只需要把0变为-1 转化为求和为0的最长连续子数组长度
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No11 {
    public static void main(String[] args) {
        // -1,1,1,1,-1,1,1,-1
        int nums[] = new int[]{0,1,1,1,0,1,1,0};
        System.out.println("最长连续子数组长度："+findMaxLength(nums));
    }
    
//    public static int findMaxLength(int nums[]){
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(0,-1);
//        int sum = 0;
//        int maxLength = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum+= nums[i] == 0 ? -1 : 1;
//            if (map.containsKey(sum)){
//                maxLength = Math.max(maxLength,i - map.get(sum));
//            }else {
//                map.put(sum,i);
//            }
//        }
//        return maxLength;
//    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
