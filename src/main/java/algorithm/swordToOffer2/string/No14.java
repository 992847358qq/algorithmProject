package algorithm.swordToOffer2.string;

/**
 * @description: 字符串中的变位词
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No14 {
    //时间复杂度扫描了s1和s2，s1长度为m，s2长度为n，时间复杂度为O(m+n)
    //空间复杂度 长度为26的数组，空间复杂度为O(1)
    public static void main(String[] args) {
        String s1 = "are";
        String s2 = "sdraedra";
        System.out.println(new No14().checkInclusion(s1,s2));
    }

    public boolean checkInclusion(String s1,String s2){
        if (s2.length() < s1.length()){
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        if (areAllzero(count)){
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a'] --;
            count[s2.charAt(i - s1.length()) - 'a'] ++;
            if (areAllzero(count)){
                return true;
            }
        }
        return false;
    }

    public boolean areAllzero(int[] count){
        for (int c:count){
            if (c != 0){
                return false;
            }
        }
        return true;
    }
}
