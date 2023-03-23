package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description: 所有大于或等于节点的值之和
 * @author: gaoliang.wang
 * @date: 2022/3/2 8:36 PM
 **/
public class No54 {
    public TreeNode  convertBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum+=cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
