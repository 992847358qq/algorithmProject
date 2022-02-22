package algorithm.swordToOffer2.string;

/**
 * @description: 有效的回文
 * @author: gaoliang.wang
 * @date: 2022-02-14
 **/
public class No18 {
    public static void main(String[] args) {
        String s = "was it a cat i saw";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() -1;
        while (i<j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
