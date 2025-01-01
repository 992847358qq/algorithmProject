package leetcode;

/**
 * @description: 最长回文子串
 * @author: gaoliang.wang
 * @date: 2022/5/4 6:58 PM
 **/
public class leet5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        String result = "";
        for(int i = 0;i<s.length();i++){
            //从中间开始向两边查找。由于形成回文，中间可能是1个字符，也可能是两个字符
            String s1 = countPalindrome(s,i,i);
            if(s1.length()>result.length()){
                result = s1;
            }
            String s2 = countPalindrome(s,i,i+1);
            if(s2.length()>result.length()){
                result = s2;
            }
        }
        return result;
    }

    public String countPalindrome(String s,int start,int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}
