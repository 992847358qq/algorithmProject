package algorithm.swordToOffer2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 数组中和为0的3个数字
 * 排序，先固定一个数字i，求另外两个数字和=-i
 * @author: gaoliang.wang
 * @date: 2022-02-10
 **/
public class No7 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length>=3){
            Arrays.sort(nums);
            int i = 0;
            while (i<nums.length-2){
                twoSum(nums,i,result);
                int temp = nums[i];
                while (i<nums.length && nums[i] == temp){
                    i++;
                }
            }
        }
        return result;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i+1;
        int k = nums.length - 1;
        while (j<k){
            if (nums[i] + nums[j] + nums[k] == 0){
                result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                int temp = nums[j];
                while (nums[j] == temp && j<k){
                    j++;
                }
            }else if (nums[i] + nums[j] + nums[k] <0 ){
                j++;
            }else {
                k--;
            }
        }
    }
}
