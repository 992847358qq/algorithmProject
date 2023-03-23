package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉搜索树迭代器
 * @author: gaoliang.wang
 * @date: 2022/3/2 10:57 PM
 **/
public class No55 {
    public TreeNode cur;
    public Stack<TreeNode> stack;
    public No55(TreeNode root){
        cur = root;
        stack = new Stack<>();
    }
    public Boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }

    public int next(){
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int value = cur.val;
        cur = cur.right;
        return value;
    }
}
