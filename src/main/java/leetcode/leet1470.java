package leetcode;

import java.util.Arrays;

/**
 * @Author: wgl
 * @Date: 2020/07/07 19:41
 * @Description:
 */
public class leet1470 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,1,3,4,7};
        int n = 3;
        int[] solution = new leet1470().solution(nums, n);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(int[] nums, int n){
        int[] newNums = new int[n << 1];
        int index = 0;
        for(int i=0;i<n;i++){
            newNums[index++] = nums[i];
            newNums[index++] = nums[n+i];
        }
        return newNums;
    }
}
