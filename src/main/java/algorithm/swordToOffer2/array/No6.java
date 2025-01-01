package algorithm.swordToOffer2.array;

import java.util.Arrays;

/**
 * @description: 排序数组中的两个数字之和，比如数字k，找出数组中哪两个数字之和等于k，输出这两个数字的下标
 * 运用双指针 双指针只适用于数组中都是正数 排序数组
 * @author: gaoliang.wang
 * @date: 2022-02-10
 **/
public class No6 {
    //时间复杂度O(n)
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6,10};
        int k = 8;
        System.out.println(Arrays.toString(twoSum(nums,k)));
    }
    public static int[] twoSum(int[] nums , int k ){
        int i = 0;
        int j = nums.length -1 ;
        while (i<j && ( nums[i] + nums[j]!= k)){
            if (nums[i] + nums[j] > k){
                j --;
            }else {
                i++;
            }
        }
        return new int[]{i,j};
    }
}
