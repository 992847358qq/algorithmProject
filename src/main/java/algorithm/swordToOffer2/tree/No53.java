package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉搜索树的下一个节点
 * @author: gaoliang.wang
 * @date: 2022/3/2 8:36 PM
 **/
public class No53 {
    public TreeNode inorderSuccesser(TreeNode root,TreeNode p){
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Boolean found = false;
        while (cur!=null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (found){
                break;
            }else if (cur.val == p.val){
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }
    //按照中序遍历的思想；查找p的下一节点，那么这个节点一定是大于或等于p的。
    // 就在p节点的右子树里面，且是右子树里面最小的值
    public TreeNode inorderSuccesser2(TreeNode root,TreeNode p){
        if (root == null || p == null){
            return null;
        }
        TreeNode cur = root;
        TreeNode reuslt = null;
        while (cur!= null){
            if (cur.val >p.val){
                reuslt = cur;
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return reuslt;
    }
}
