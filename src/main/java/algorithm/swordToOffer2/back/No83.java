package algorithm.swordToOffer2.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 没有重复元素集合的全排列
 * @author: gaoliang.wang
 * @date: 2022/3/16 11:42 PM
 **/
public class No83 {

    public static void main(String[] args) {
        No83 no83 = new No83();
        int[] nums = new int[]{1,2,3};
        no83.permute(nums).toString();
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums,0,result);
        return result;
    }
    // 1 2 3   2 1 3    2 3 1
    //3 2 1   3 1 2  1 3 2
    private void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length){
            List<Integer> permutation = new LinkedList<>();
            for (int num:nums){
                permutation.add(num);
            }
            result.add(permutation);
        }else {
            //当选择第i元素时，元素可以是i-(n-1)之间的任一一个。
            //所有让i与n-1之间的元素进行交换，然后选择下一个元素
            //返回到父级时，再把位置交换回来
            for (int j = i; j < nums.length; j++) {
                swap(nums,i,j);
                helper(nums, i+1, result);
                swap(nums,i,j);
            }
        }
    }

    private void swap(int[] nums,int i , int j){
        if (i!=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
