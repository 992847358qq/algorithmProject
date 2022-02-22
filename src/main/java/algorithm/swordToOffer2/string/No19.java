package algorithm.swordToOffer2.string;

/**
 * @description: 最多删除一个字符得到回文
 * //先双指针，最左边与最右边依次比较。如果不相等，那么这个字符可能在最左边，也可能在最右边。
 * //那么移除左边元素继续比较   || 移除右边元素继续比较
 * @author: gaoliang.wang
 * @date: 2022-02-14
 **/
public class No19 {
    public static void main(String[] args) {
        String str = "abca";
        System.out.println(validPalindrome(str));
    }

    public static boolean validPalindrome(String str){
        int start = 0;
        int end = str.length() -1;
        for (; start < str.length()/2 ; start++,end--) {
            if (str.charAt(start) != str.charAt(end)){
                break;
            }
        }
        return start == str.length()/2 || isPalindrome(str,start,end-1) || isPalindrome(str,start+1,end);
    }

    private static boolean isPalindrome(String str,int start,int end){
        while (start<end){
            if (str.charAt(start) != str.charAt(end)){
                break;
            }
            start++;
            end--;
        }
        return start>=end;
    }
}
