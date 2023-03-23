package algorithm.swordToOffer2.dp;

/**
 * @description: 翻转字符 只包含0和1的字符串，需要0都在1前面。
 * 0可以变成1，1也可以变成0
 * @author: gaoliang.wang
 * @date: 2022/3/25 10:08 PM
 **/
public class No92 {
    /**
     *     00110，分析只要把最后一位0变为1  00111就满足条件
     *     字符串从第0位到第i位，这个字符串的长度为i+1。
     *     如果前i个字符经过反转满足条件，最后一位是0，那么第i个字符不管是0和1都满足条件
     *     如果前i个字符经过反转满足条件，最后一位是1，那么第i个字符必须是1
     *     f(i)表示下标从第0个字符到第i个字符变成符合条件的字符且最后一位字符是0的最小成本
     *     g(i)表示下标从第0个字符到第i个字符变成符合条件的字符且最后一位字符是1的最小成本
     *     如果字符串长度是n，那么f(n-1)和g(n-1)的最小值是翻转的最小成本
     *     当第i位是0时，那么i-1位也必须是0；f(i)=f(i-1);当i位是1时，f(i)=f(i-1)+1;
     *     当第i位是1时，那么第i-1位不管是0和1都满足g(i)=Math.min(f(i-1),g(i-1));当i位是0时，g(i)=Math.min(f(i-1),g(i-1))+1
     */

    public int minFlipsMonoIncr(String s) {
        int len = 0;
        if (s == null || (len = s.length()) == 0){
            return 0;
        }
        int[][] dp = new int[2][2];
        char ch = s.charAt(0);
        dp[0][0] = ch == '0'?0:1;
        dp[1][0] = ch == '1'?0:1;
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            int prev0 = dp[0][(i-1)%2];
            int prev1 = dp[1][(i-1)%2];
            dp[0][i%2] = prev0 + (ch == '0'?0:1);
            dp[1][i%2] = Math.min(prev0,prev1) + (ch == '1'?0:1);
        }
        return Math.min(dp[0][(len-1)%2],dp[1][(len-1)%2]);
    }

}
