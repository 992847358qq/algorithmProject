package algorithm.swordToOffer2.dp;

import java.util.Arrays;

/**
 * @description: 房屋偷盗
 * @author: gaoliang.wang
 * @date: 2022/3/22 11:03 PM
 **/
public class No89 {
    //临界值
    //状态转移方程
    //最优解
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        helper(nums,nums.length-1,dp);
        return dp[nums.length-1];
    }
    //f(i)只计算一次，空间复杂度为O(n)，时间复杂度为O(n)
    //自上而下
    private void helper(int[] nums, int i, int[] dp) {
        if (i == 0){
            dp[i] = nums[0];
        }else if (i==1){
            dp[i] = Math.max(nums[0],nums[1]);
        }else {
            helper(nums,i-2,dp);
            helper(nums,i-1,dp);
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
    }


    //自下而上 时间和空间复杂度都为O(n)
    public int rob1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        if (nums.length>1){
            dp[1] = Math.max(nums[0],nums[1]);
        }
        for (int i = 2; i <nums.length ; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    //空间复杂度为1
    public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[2];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        if (nums.length>1){
            dp[1] = Math.max(nums[0],nums[1]);
        }
        for (int i = 2; i <nums.length ; i++) {
            //i =2 ->
            dp[i%2] = Math.max(dp[(i-2)%2]+nums[i],dp[(i-1)%2]);
        }
        return Math.max(dp[0],dp[1]);
    }
}
