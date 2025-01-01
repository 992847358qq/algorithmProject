package algorithm.swordToOffer2.dp;

/**
 * @description: 环形房屋偷盗
 * @author: gaoliang.wang
 * @date: 2022/3/22 11:41 PM
 **/
public class No90 {
    //确定状态转移方程，因为房子是环形的，相邻的房子不能偷
    //如果有n个房子，那么只能偷0-(n-1)   和 1-n
    //求0~(n-1)   和 1~n的最优解
    //偷第i个房子，那么i-1的房子就不能偷 f(i) = Math.max(f(i-1),f(i-1)+i)



    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(new No90().rob(nums));
    }
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int result = helper(nums,0,nums.length-2);
        int result1 = helper(nums,1,nums.length-1);
        return Math.max(result,result1);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        if (start<end){
            dp[1] = Math.max(nums[start],nums[start+1]);
        }
        for (int i = start+2; i <= end; i++) {
            int j = i - start;
            dp[j%2] = Math.max(dp[(j-2)%2]+nums[i],dp[(j-1)%2]);
        }
        return dp[(end-start)%2];
    }
}
