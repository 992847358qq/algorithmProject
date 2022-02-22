package algorithm.swordToOffer2.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 乘积小于k的子数组
 * @author: gaoliang.wang
 * @date: 2022-02-11
 **/
public class No9 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        int k = 100;
        System.out.println(test(nums,k));
    }
    public static int test(int[] nums ,int k){
        int left = 0;
        long product = 1;
        int count = 0;
        for (int right = 0; right < nums.length ; right++) {
            product *= nums[right];
            while (left <= right && product >= k){
                product /= nums[left++];
            }
            count += right >=left?right-left+1:0;
        }
        return count;
    }
}
