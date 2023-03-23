package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/7/14 11:06 AM
 **/
public class OrderTest1 {

    public void preDfsOrder(TreeNode head){
        if (head != null){
            System.out.println(head.val);
            preDfsOrder(head.left);
            preDfsOrder(head.right);
        }
    }

    public void preOrder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()){
            while (cur!= null){
                stack.add(cur);
                System.out.println(cur.val);
                cur = cur.left;
            }
           cur =  stack.pop();
           cur = cur.right;
        }

    }

    public void midDfsrder(TreeNode head){
        if (head != null){
            midDfsrder(head.left);
            System.out.println(head.val);
            midDfsrder(head.right);
        }
    }

    public void midOrder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (cur != null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }

    }

    public void postDfsOrder(TreeNode head){
        if (head != null){
            postDfsOrder(head.left);
            postDfsOrder(head.right);
            System.out.println(head.val);
        }
    }

    public void postOrder(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        TreeNode pre = head;
        while (cur != null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
           cur =  stack.peek();
            if (cur.right != null && cur.right != pre){
                stack.push(cur.right);
            }else {
                stack.pop();
                pre = cur;
                System.out.println(cur.val);
                cur = cur.right;
            }
        }

    }

}
