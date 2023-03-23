package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

/**
 * @description: 从根节点到叶节点的路径数字之和
 * 根节点到叶节点
 * @author: gaoliang.wang
 * @date: 2022/3/1 12:04 AM
 **/
public class No49 {

    public int sunNumbers(TreeNode root){
       return dfs(root,0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null){
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null){
            return path;
        }
        return dfs(root.left,path) + dfs(root.right,path);
    }
}
