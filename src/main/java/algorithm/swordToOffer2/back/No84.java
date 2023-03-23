package algorithm.swordToOffer2.back;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @description: 含有重复元素的集合的全排列
 * @author: gaoliang.wang
 * @date: 2022/3/17 12:11 AM
 **/
public class No84 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums,0,result);
        return result;
    }

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
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                //交换过之后，再碰到相同的值不需要交换
                if (!set.contains(nums[j])){
                    set.add(nums[j]);
                    swap(nums,i,j);
                    helper(nums, i+1, result);
                    swap(nums,i,j);
                }

            }
        }
    }

    private void swap(int[] nums,int i , int j){
        if (i!=j  && nums[i] != nums[j]){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
