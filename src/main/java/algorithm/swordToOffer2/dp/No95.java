package algorithm.swordToOffer2.dp;

/**
 * @description: 双序列问题 最长子序列
 * @author: gaoliang.wang
 * @date: 2022/3/26 2:01 PM
 **/
public class No95 {
    /**
     * 求两个字符串的最长子序列
     * 确定状态转移方程
     * f(i,j)表示第一个字符串第i个字符  和 第二个字符串第j个字符的最长子序列
     * 假如第一个字符串第i个字符 和第二个字符串第j个字符相同 那么f(i,j) = f(i-1,j-1)+1;
     * 如果第一个字符串第i个字符 和第二个字符串第j个字符不相同
     * 那么f(i,j) = max(f(i,j-1),f(i-1,j));
     * 确定临界值
     * 当字符串长度为1时,f(0,0) = f(0,-1)  或者f(-1,0) 相当于字符串向前减一位，是空字符串，长度为0
     * 时间复杂度O(ij)
     * 由于存在-1的问题，就把数组长度多加1，f(i,j)=dp[i+1][j+1];
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int [][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[len1][len2];
    }
    //f(i,j) = f(i-1,j-1)+1;    f(i,j) = max(f(i,j-1),f(i-1,j));
    //i依赖于i-1行 或者依赖于同一行左边的值
    public int longestCommonSubsequence1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1<len2){
            return longestCommonSubsequence(text2,text1);
        }
        int [][] dp = new int[2][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[(i+1)%2][j+1] = dp[i%2][j]+1;
                }else {
                    dp[(i+1)%2][j+1] = Math.max(dp[(i+1)%2][j],dp[i%2][j+1]);
                }
            }
        }
        return dp[len1%2][len2];
    }
}
