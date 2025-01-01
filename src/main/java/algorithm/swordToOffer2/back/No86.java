package algorithm.swordToOffer2.back;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 分割回文子字符串
 * @author: gaoliang.wang
 * @date: 2022/3/17 10:09 PM
 **/
public class No86 {
    public static void main(String[] args) {
        String str = "bbbbbbbbbbbbbbbb";
        new No86().partition(str);
    }

    public String[][] partition(String s) {
        List<List<String>> result = new LinkedList<>();
        helper(s,0,new LinkedList<>(),result);
        String[][] arrs = new String[result.size()][s.length()];
        for (int i = 0; i < result.size(); i++) {
            arrs[i] = result.get(i).toArray(new String[0]);
        }
        return arrs;
    }

    private void helper(String s, int start, LinkedList<String> objects, List<List<String>> result) {
        if (start == s.length()){
            result.add(new LinkedList<>(objects));
            return;
        }
        //构建回文字符，字符串长度为n，当前位置为第k个字符,下一个可以选取1个，2个，3个等等到n-k个字符
        for (int i = start; i < s.length() ; i++) {
            if (isPalindrome(s,start,i)){
                //字符串截取左闭右开
                objects.add(s.substring(start,i+1));
                //选择下一个
                helper(s,i+1,objects,result);
                //清除最后一个，回到父级
                objects.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start<end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
