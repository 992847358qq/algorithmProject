package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

/**
 * @description: 二叉树剪枝
 * @author: gaoliang.wang
 * @date: 2022/2/28 11:29 PM
 **/
public class No47 {
    public TreeNode pruneTree(TreeNode root){
        if (root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.left == null && root.val == 0){
            return null;
        }
        return root;
    }
}
