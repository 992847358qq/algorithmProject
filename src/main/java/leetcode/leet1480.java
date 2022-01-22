package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wgl
 * @Date: 2020/07/07 20:11
 * @Description:
 */
public class leet1480 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] ints = new leet1480().runningSum(nums);
        System.out.println(Arrays.toString(ints));
    }
    public int[] runningSum(int[] nums) {
        int count = nums.length;
        int index = 0;
        int[] newNums = new int[count];
        for(int i = 0;i<count;i++){
            index +=nums[i];
            newNums[i] = index;
        }
        return newNums;
    }
}
