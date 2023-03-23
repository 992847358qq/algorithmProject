package algorithm.niuke;

/**
 * @description: 最长公共子序列二  求最值，用动态规划
 * @author: gaoliang.wang
 * @date: 2022/5/2 5:10 PM
 **/
public class Bm65 {
    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(LCS(s1, s2));
    }

    public static String LCS (String s1, String s2) {
        // write code here
        if (s1.length() == 0 || s1 == ""){
            return "-1";
        }
        if (s2.length() == 0 || s2 == ""){
            return "-1";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        String [][] dp = new String[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    if (dp[i][j] == null){
                        dp[i][j] = "";
                    }
                    dp[i+1][j+1] = dp[i][j]+s1.charAt(i);
                }else {
                    if (dp[i+1][j] == null){
                        dp[i+1][j] = "";
                    }
                    if (dp[i][j+1] == null){
                        dp[i][j+1] = "";
                    }
                    if (dp[i+1][j].length()<=dp[i][j+1].length()){
                        dp[i+1][j+1] =  dp[i][j+1];
                    }else {
                        dp[i+1][j+1] = dp[i+1][j];
                    }
                }
            }
        }
        return dp[len1][len2].length()>0?dp[len1][len2]:"-1";
    }
}
