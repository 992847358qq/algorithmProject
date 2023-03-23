package algorithm.swordToOffer2.back;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 允许重复选择元素的集合
 * @author: gaoliang.wang
 * @date: 2022/3/15 11:40 PM
 **/
public class No81 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(result,0,candidates,target,combination);
        return  result;
    }

    private void helper(List<List<Integer>> result, int i ,int[] nums, int target, LinkedList<Integer> combination) {
        if (target == 0){
            result.add(new LinkedList<>(combination));
        }else if (target >0 && i< nums.length){
            //不选择当前元素
            helper(result,i+1,nums,target,combination);
            //选择当前元素
            combination.add(nums[i]);
            //可以选择重复元素，继续选择当前元素
            helper(result, i, nums, target-nums[i], combination);
            combination.removeLast();
        }
    }


}
