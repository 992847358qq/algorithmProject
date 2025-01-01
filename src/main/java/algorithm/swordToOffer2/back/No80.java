package algorithm.swordToOffer2.back;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 包含k个元素的组合
 * @author: gaoliang.wang
 * @date: 2022/3/15 11:24 PM
 **/
public class No80 {
    public static void main(String[] args) {
        No80 no80 = new No80();
        List<List<Integer>> combine = no80.combine(3, 2);
        System.out.println(combine.toString());
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        if (n<k){
            return result;
        }
        helper(result,n,k,1,combination);
        return  result;
    }

    private void helper(List<List<Integer>> result, int n, int k, int i, LinkedList<Integer> combination) {
        if (combination.size() == k){
            result.add(new LinkedList<>(combination));
        }else if (i<=n){
            helper(result,n,k,i+1,combination);
            combination.add(i);
            helper(result,n,k,i+1,combination);
            combination.removeLast();
        }
    }
}
