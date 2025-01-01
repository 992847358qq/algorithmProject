package algorithm.niuke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 字符串排序
 * @author: gaoliang.wang
 * @date: 2022/4/28 10:07 PM
 **/
public class Bm58 {
    public static void main(String[] args) {
        String str = "aa";
        ArrayList<String> permutation = new Bm58().Permutation(str);
        System.out.println(permutation);
    }


    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        helper(chars,result,0);
        return result;
    }

    private void helper(char[] str, ArrayList<String> result, int len) {
        if (len == str.length){
            result.add(new String(str));
        }else {
            Set<Character> set = new HashSet<>();
            for (int i = len; i < str.length ; i++) {
                //选择任一元素交换当前位置，需要判断是否交换过；没有交换过，进行交换
                if (!set.contains(str[i])){
                    set.add(str[i]);
                    swap(str,len,i);
                    //选择下一个位置
                    helper(str,result,len+1);
                    //回到父级交换回位置
                    swap(str,len,i);
                }
            }
        }
    }

    public void swap(char[] str,int i,int j){
        if (i != j && str[i] != str[j]){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
