package algorithm.swordToOffer2.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串中所有的变位词
 * 去s2的变位词在s1子字符串中的起始下标
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No15 {
    public static void main(String[] args) {
        String s1 = "cbadabacg";
        String s2 = "abc";
        System.out.println(new No15().findAnyIndex(s1,s2).toString());
    }

    public List<Integer> findAnyIndex(String s1,String s2){
        List<Integer> list = new ArrayList<>();
        if (s1.length() < s2.length()){
            return list;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a'] ++;
            counts[s1.charAt(i) - 'a'] --;
        }
        if (areAllzero(counts)){
            list.add(0);
        }
        for (int i = s2.length(); i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a'] --;
            counts[s1.charAt(i - s2.length()) - 'a'] ++;
            if (areAllzero(counts)){
                list.add(i-s2.length()+1);
            }
        }
        return list;
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
