package algorithm.swordToOffer2.hash;

/**
 * @description: 有效的变位词
 * 如果都为小写字符，用26长度的数组来模拟哈希表
 * 如果包含中文特殊字符，就用哈希表map来比较
 * @author: gaoliang.wang
 * @date: 2022-02-25
 **/
public class No32 {
    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        if (s.length() ==1 || s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) -'a']--;
        }
        for (int j = 0; j < 26; j++) {
            if (nums[j] != 0){
                return false;
            }
        }
        return true;
    }
}
