package algorithm.swordToOffer2.dp;

/**
 * @description: 背包问题-分割等和子集
 * @author: gaoliang.wang
 * @date: 2022/3/29 12:10 AM
 **/
public class No101 {
    public static void main(String[] args) {
        int[] nums = new int[]{6};
        System.out.println(getPartition(nums));
        System.out.println(+1-1+1);
    }

    public static  boolean getPartition(int[] nums){
        int sum = 0;
        for (int num:nums){
            sum+= num;
        }
        if(sum % 2 == 1){
            return  false;
        }
        return  subsetSum(nums,sum/2);
    }

    public static boolean subsetSum(int[] nums,int target){
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target ; j++) {
                dp[i][j] = dp[i-1][j];
                if (!dp[i][j] && j>= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
