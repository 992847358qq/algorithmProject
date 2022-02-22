package algorithm.swordToOffer2.string;

/**
 * @description: 回文字符串的个数
 * @author: gaoliang.wang
 * @date: 2022-02-14
 **/
public class No20 {
    public static void main(String[] args) {
        // a/b/c/d/ab/bc/cd/abc/bcd/abcd/de/bcde/cde/abcde
        String str ="abcdedcba";
        System.out.println(countString(str));
        System.out.println(countSubstrings(str));
    }

    public  static  int countString(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += countPalindrome(str,i,i);
            count += countPalindrome(str,i,i+1);
        }
        return count;
    }

    private static int countPalindrome(String str, int start, int end) {
        int count = 0;
        while (start >=0 && end<str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    }

    public static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
