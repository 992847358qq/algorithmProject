package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/2/28 9:27 PM
 **/
public class Order {

    /**
     * 中序遍历
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        inDfs(root,result);
        return result;

    }
    //中序遍历递归
    public void inDfs(TreeNode root, List<Integer> result) {
        if (root != null){
            inDfs(root.left,result);
            result.add(root.val);
            inDfs(root.right,result);
        }
    }
    //中序遍历非递归
    public List<Integer>  inorderTraversal(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    /**
     * 前序遍历
     */

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        preDfs(root,result);
        return result;
    }

    private void preDfs(TreeNode root, List<Integer> result) {
        if (root != null){
            result.add(root.val);
            preDfs(root.left,result);
            preDfs(root.right,result);
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null && !stack.isEmpty()){
            while (cur != null){
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

    /**
     * 后序遍历
     */

    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        postDfs(root,result);
        return result;
    }

    private void postDfs(TreeNode root, List<Integer> result) {
        if (root != null){
            postDfs(root.left,result);
            postDfs(root.right,result);
            result.add(root.val);
        }
    }

    public List<Integer> postOrderTraversal(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null && !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev){
                cur = cur.right;
            }else {
                stack.pop();
                result.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return result;
    }

}
