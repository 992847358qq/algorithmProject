package algorithm.swordToOffer;

import java.util.Stack;

/**
 * @author MR.Wang
 * @dept 用两个栈实现队列 队列：先进先出；栈：先进后出
 * @description TODO
 * @date 2021/1/24 22:52
 **/
public class No9 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        appendTail(stack,stack1,1);
        appendTail(stack,stack1,2);
        appendTail(stack,stack1,3);
        deleteHead(stack,stack1);
        deleteHead(stack,stack1);
        System.out.println(stack.size());// 0
        System.out.println(stack1.size()); // 1
    }
    //队列尾部插入节点
    public static void appendTail(Stack<Integer> stack,Stack<Integer> stack1,Integer num){
            stack.push(num);
    }
    //在队列头部删除节点
    public static void deleteHead(Stack<Integer> stack,Stack<Integer> stack1){
        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        if (!stack1.isEmpty()){
            stack1.pop();
        }
    }
}
