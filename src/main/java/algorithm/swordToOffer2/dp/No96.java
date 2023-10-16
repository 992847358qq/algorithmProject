package algorithm.swordToOffer2.dp;

/**
 * @description: 字符串交织
 * @author: gaoliang.wang
 * @date: 2022/3/26 4:46 PM
 **/
public class No96 {

    public static void main(String[] args) {
        System.out.println(new No96().isInterleave1("aabc","dbc","aadbbcc"));
        //System.out.println(new No96().isInterleave1("","a","a"));
    }

    //采用回溯法解决
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if((len1|len2|len3) == 0){
            return true;
        }
        if(len1 + len2 != len3){
            return false;
        }
        int [] result = new int[1];
        helper(s1,s2,s3,"",0,0,0,result);
        return result[0] == 1?true:false;
    }

    public void helper(String s1,String s2,String s3,String str,int len1,int len2,int index,int[] result){
        if(str.equals(s3)){
            result[0] = 1;
        }else if(index < s3.length()){
            //拼接s1字符
            if(len1 < s1.length()){
                helper(s1,s2,s3,str + s1.charAt(len1),len1+1,len2,index+1,result);
            }
            //拼接s2字符
            if(len2 < s2.length()){
                helper(s1,s2,s3,str + s2.charAt(len2),len1,len2+1,index+1,result);
            }
        }
    }
    // "aabcc","dbbca","aadbbcbcac"
    public boolean isInterleave1(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[2][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[(i+1)%2][0] = s1.charAt(i) == s3.charAt(i) && dp[i%2][0];
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j+1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i+j+1);
                dp[(i+1)%2][j+1] = (ch1 == ch3 && dp[i%2][j+1]) || (ch2 == ch3 && dp[(i+1)%2][j]);
            }
        }
        return dp[s1.length()%2][s2.length()];
    }
}
