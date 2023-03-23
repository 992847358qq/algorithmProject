package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/5/29 11:33 AM
 **/
public class leet1021 {

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    public static String removeOuterParentheses(String s) {
        if(s == null || s.length()<2){
            return "";
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int leftCount = 0;
        int rightCount = 0;
        while(index <= s.length()-1){
            if(s.charAt(index) == '('){
                leftCount+=1;
            }else{
                rightCount+=1;
            }
            sb.append(s.charAt(index));
            index++;
            if(leftCount == rightCount){
                result.append(sb.substring(1,sb.length()-1));
                sb.delete(0,sb.length());
            }
        }
        return result.toString();
    }
}
