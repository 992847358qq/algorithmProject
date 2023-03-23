package algorithm.swordToOffer2.dp;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/24 11:57 PM
 **/
public class No91 {
    //粉刷房子，房子有三个颜色可以选红色、绿色、蓝色，数组下标0,1,2分别代表其成本
    //r(i),g(i),b(i)分别表示第i个房子粉刷为红色、绿色、蓝色时，从第1栋房子到第栋房子的最小成本
    //当第i栋分刷为红色时,i-1栋可以粉刷为绿色或者蓝色，求第i-1栋的最小成本r(i)=Math.min(g(i-1),b(i-1))+cost[i][0];
    //当第i栋分刷为绿色时,i-1栋可以粉刷为红色或者蓝色，求第i-1栋的最小成本g(i)=Math.min(r(i-1),b(i-1))+cost[i][1];
    //当第i栋分刷为蓝色时,i-1栋可以粉刷为红色或者绿色，求第i-1栋的最小成本b(i)=Math.min(g(i-1),r(i-1))+cost[i][2];
    public int minCost(int[][] costs) {
        if (costs.length == 0){
            return 0;
        }
        int[][] dp = new int[3][2];
        //{[17],[2],[16]}
        for (int i = 0; i <3 ; i++) {
            dp[i][0] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(j+2)%3][(i-1)%2];
                int prev2 = dp[(j+1)%3][(i-1)%2];
                dp[j][i%2] = Math.min(prev1,prev2)+costs[i][j];
            }
        }

        int last = (costs.length-1)%2;
        return Math.min(dp[0][last],Math.min(dp[1][last],dp[2][last]));

    }
}
