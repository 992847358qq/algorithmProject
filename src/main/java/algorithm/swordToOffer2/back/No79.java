package algorithm.swordToOffer2.back;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 所有子集
 * @author: gaoliang.wang
 * @date: 2022/3/15 10:50 PM
 **/
public class No79 {

    public static void main(String[] args) {
        int[] nums  = new int[]{1,2,3};
        List<List<Integer>> subsets = new No79().subsets(nums);
        System.out.println(subsets.toString());
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0){
            return result;
        }
        helper(nums,0,new LinkedList<Integer>(),result);
        return result;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        //等于数组长度时，表示所有数字都处理过了，添加集合
        if (index == nums.length){
            result.add(new LinkedList<>(subset));
        }else if (index<nums.length){
            //对当前不做选择，直接进入下一个
            helper(nums, index+1, subset, result);
            //添加当前选择
            subset.add(nums[index]);
            //进入下一个
            helper(nums, index+1, subset, result);
            //移除当前，回到父节点
            subset.removeLast();
        }
    }
}
