package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉搜索树中两个节点的值之和
 * 双指针，第一个指针指向最小的，第二个指针指向最大。
 * 类似于求数组中两个整数之和
 * @author: gaoliang.wang
 * @date: 2022/3/2 10:58 PM
 **/
public class No56 {

    class BSTIteratorReversed{
        public TreeNode cur;
        public Stack<TreeNode> stack;
        public BSTIteratorReversed(TreeNode root){
            this.cur = root;
            this.stack = new Stack<>();
        }
        public boolean hasNext(){
            return cur != null || !stack.isEmpty();
        }
        public int prev(){
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
             cur = stack.pop();
             int value = cur.val;
             cur = cur.left;
             return value;
        }
    }
    //时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public boolean findTarger(TreeNode root,int target){
        if (root == null){
            return false;
        }
        No55 no55 = new No55(root);
        BSTIteratorReversed bstIteratorReversed = new BSTIteratorReversed(root);
        int next = no55.next();
        int prev = bstIteratorReversed.prev();
        while (next != prev){
            if (next+prev == target){
                return true;
            }
            if (next+prev>target){
                prev = bstIteratorReversed.prev();
            }else {
                next = no55.next();
            }
        }
        return false;
    }
}
