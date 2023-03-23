package algorithm.niuke;

import java.util.*;

/**
 * @description: 有重复项数字的全排列
 * @author: gaoliang.wang
 * @date: 2022/4/26 11:04 PM
 **/
public class Bm56 {
    public static void main(String[] args) {
        int[] num = new int[]{1,1,2};
        ArrayList<ArrayList<Integer>> permute = new Bm55().permute(num);
        System.out.println(permute);
    }


    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(num,0,result);
        return result;
    }

    private void helper(int[] num, int i, ArrayList<ArrayList<Integer>> result) {
        if (i == num.length){
            ArrayList<Integer> arr = new ArrayList<>();
            for (int m:num){
                arr.add(m);
            }
            result.add(arr);
        }else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < num.length; j++) {
                //选择i~num.length-1之间一个元素，交换位置
                //如果相同，说明交换过了，重复了
                if (!set.contains(num[j])){
                    set.add(num[j]);
                    swap(num,j,i);
                    //选择下一个元素
                    helper(num,i+1,result);
                    //返回到父级，还原位置，继续交换下一个元素
                    swap(num,j,i);
                }

            }
        }
    }

    private void swap(int[] num, int j, int i) {
        if (i!=j  && num[i] != num[j]){
            int temp = num[j];
            num[j] = num[i];
            num[i] = temp;
        }
    }
}
