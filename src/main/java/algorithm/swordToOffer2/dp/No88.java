package algorithm.swordToOffer2.dp;

/**
 * @description: 爬楼梯的最小成本
 * @author: gaoliang.wang
 * @date: 2022/3/21 10:32 PM
 **/
public class No88 {

    //求最优解，适合动态规划。
    //先确定状态转移方法f(n)表示爬到第n节楼梯的成本。由于爬楼梯一次可以爬1节或2节即f(n-1)和f(n-2)就是这个问题的最优解
    //可以求得第i节楼梯的最优解f(i)=min(f(i-1),f(i-2))+cost[i];cost数组表示每个楼梯的成本


    //递归，效率很差，执行时间超时
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        return Math.min(helper(cost,len-2),helper(cost,len-1));
    }

    private int helper(int[] cost, int i) {
        if (i<2){
            return cost[i];
        }
        return Math.min(helper(cost,i-2),helper(cost,i-1))+cost[i];
    }

    //使用备忘录方式，记录重复计算的值

    public static void main(String[] args) {
        int[] cost = new int[]{1,100};
        new No88().new No88_1().minCostClimbingStairs(cost);
    }


    class No88_1{
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len];
            if (cost.length<=2){
                return Math.min(cost[len-2],cost[len-1]);
            }
            helper(cost,len-1,dp);
            return Math.min(dp[len-2],dp[len-1]);
        }

        private void helper(int[] cost, int i, int[] dp) {
            if (i<2){
                dp[i] =  cost[i];
            }else if (dp[i] == 0){
                helper(cost,i-2,dp);
                helper(cost,i-1,dp);
                dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
            }
        }
    }

    class No88_2{
        //备忘录+迭代的方式
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len];
            dp[0]=cost[0];
            dp[1]=cost[1];
            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
            }
            return Math.min(dp[len-2],dp[len-1]);
        }
    }

    class No88_3{
        //备忘录+迭代的方式
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[]{cost[0],cost[1]};
            for (int i = 2; i < cost.length; i++) {
                dp[i%2] = Math.min(dp[0],dp[1])+cost[i];
            }
            return Math.min(dp[0],dp[1]);
        }
    }

}
