package algorithm.niuke;

import java.util.Stack;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/23 9:52 PM
 **/
public class Bm42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //stack1负责插入，stack2负责删除
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
