package algorithm.niuke;

import java.util.Stack;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/23 10:39 PM
 **/
public class Bm44 {

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(new Bm44().isValid(str));
    }
    public boolean isValid (String s) {
        // write code here
        if (s == null || s.length() == 0 || (s.length() % 2) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(')');
                } else if (s.charAt(i) == '{') {
                    stack.push('}');
                } else if (s.charAt(i) == '[') {
                    stack.push(']');
                }else if (stack.isEmpty() || s.charAt(i) != stack.pop()){
                    return false;
                }
            }
            return stack.isEmpty();
        }
}
