package algorithm.cartoonAlgorithm.question;

import java.util.Stack;

/**
 * @author MR.Wang
 * @dept 求最小栈
 * @description TODO
 * @date 2021/1/13 21:50
 **/
public class QueTwo {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int element){
        if (mainStack.isEmpty() || element<= minStack.peek()){
            minStack.push(element);
        }
        mainStack.push(element);
    }
    public void pop(){
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    }
    public int getMin() throws Exception {
        if (mainStack.isEmpty()){
            throw  new Exception("stack is empty");
        }
        return minStack.peek();
    }
    public static void main(String[] args) throws Exception {
        QueTwo quesTwo = new QueTwo();
        quesTwo.push(3);
        quesTwo.push(5);
        quesTwo.push(8);
        quesTwo.push(2);
        quesTwo.push(10);
        System.out.println(quesTwo.getMin());
        quesTwo.pop();
        quesTwo.pop();
        quesTwo.pop();
        System.out.println(quesTwo.getMin());
    }
}
