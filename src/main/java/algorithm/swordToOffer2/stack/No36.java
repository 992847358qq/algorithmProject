package algorithm.swordToOffer2.stack;

import java.util.Stack;

/**
 * @description: 后缀表达式
 * @author: gaoliang.wang
 * @date: 2022/2/27 12:50 AM
 **/
public class No36 {
    //通过栈解决，遇到运算符，取两位出来
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token:tokens){
            switch(token){
                case "+":
                case "-":
                case "/":
                case "*":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num2,num1,token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int calculate(int num2,int num1,String operator){
        switch(operator){
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "/":
                return num2 / num1;
            case "*":
                return num2 * num1;
            default:
                return 0;
        }
    }
}
