package algorithm.niuke;

import java.util.ArrayList;

/**
 * @description: 括号生成
 * @author: gaoliang.wang
 * @date: 2022/4/28 10:43 PM
 **/
public class Bm60 {
    public static void main(String[] args) {
        Bm60 bm60 = new Bm60();
        System.out.println(bm60.generateParenthesis(2));
    }

    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        String str = "";
        helper(result,n,n,n,str);
        return result;
    }

    private void helper(ArrayList<String> result,int n, int left, int right, String str) {
        if ( left == 0 && right == 0){
            result.add(str);
        }else {
            //先添加左括号
            if (left>0){
                helper(result,n,left-1,right,str+"(");
            }
            //右括号比左括号少，添加右括号
            if (right>left){
                helper(result,n,left,right-1,str+")");
            }
        }
    }
}
