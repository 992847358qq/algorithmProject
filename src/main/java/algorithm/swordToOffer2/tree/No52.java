package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description: 展平二叉搜索树
 *
 * @author: gaoliang.wang
 * @date: 2022/3/2 8:35 PM
 **/
public class No52 {

    public TreeNode increasingBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode first = null;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null){
                prev.right = cur;
            }else {
                first = cur;
            }
            prev = cur;
            prev.left = null;
            cur = cur.right;
        }
        return first;
    }
}
