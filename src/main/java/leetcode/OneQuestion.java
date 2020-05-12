package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wgl
 * @Date: 2020/1/7 18:35
 * @Description:
 */
public class OneQuestion {
    public static void main(String[] args) {
            int[] nums = new int[]{2,7,11,15};
            int target = 9;
            new OneQuestion().twoSum(nums,target);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>((int) ((float) nums.length / 0.75F + 1.0F));
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum value");
    }
}
