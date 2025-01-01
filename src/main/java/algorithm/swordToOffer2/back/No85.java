package algorithm.swordToOffer2.back;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 生成匹配的括号
 * @author: gaoliang.wang
 * @date: 2022/3/17 9:35 PM
 **/
public class No85 {
    public static void main(String[] args) {
        No85 no85 = new No85();
        List<String> list = no85.generateParenthesis(2);
        System.out.println(list.toString());
    }
    public List<String> generateParenthesis(int n) {
        List<String> result  = new ArrayList<>();
        int left = n;
        int right = n;
        helper(result,left,right,"");
        return result;
    }

    private void helper(List<String> result, int left, int right, String parenthesis) {
        if (left == 0 && right==0){
            result.add(parenthesis);
            return;
        }
        //当左括号大于0，就添加左括号
        if (left >0){
            helper(result,left-1,right,parenthesis+"(");
        }
        //右括号数量大于左括号数量，添加右括号
        if (right>left){
            helper(result,left,right-1,parenthesis+")");
        }
    }
}
