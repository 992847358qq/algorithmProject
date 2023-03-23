package algorithm.swordToOffer2.back;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 包含重复元素的集合的组合
 * @author: gaoliang.wang
 * @date: 2022/3/16 12:26 AM
 **/
public class No82 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(result,0,candidates,target,combination);
        return  result;
    }

    private void helper(List<List<Integer>> result, int i, int[] nums, int target, LinkedList<Integer> combination) {
        if (target == 0){
            result.add(new LinkedList<>(combination));
        }else if (target > 0 && i< nums.length){
            //不选择当前元素,排序数组相同的都不选择
            helper(result, getNext(nums,i), nums, target, combination);
            //选择当前元素
            combination.add(nums[i]);
            helper(result, i+1, nums, target-nums[i], combination);
            combination.removeLast();
        }
    }

    private int getNext(int[] nums, int i) {
        int next = i;
        while (next<nums.length && nums[next] == nums[i]){
            next++;
        }
        return next;
    }
}
