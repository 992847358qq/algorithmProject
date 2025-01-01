package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.*;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/21 9:29 PM
 **/
public class OrderTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int[] arr = new int[list.size()];
        list.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> preOrder(List<Integer> list, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur!= null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new LinkedList<>();
        midOrder(list,root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void midOrder(List<Integer> list, TreeNode root){
        //递归
//        if (root!= null){
//            midOrder(list,root.left);
//            list.add(root.val);
//            midOrder(list,root.right);
//        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
    }


    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new LinkedList<>();
        midOrder(list,root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void postOrder(List<Integer> list, TreeNode root){
        //递归
//        if (root != null){
//            postOrder(list,root.left);
//            postOrder(list,root.right);
//            list.add(root.val);
//        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur!= null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre){
                cur = cur.right;
            }else {
                cur = stack.pop();
                list.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(result,root,0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.size(); i++) {
            if (i%2 == 1){
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    public void helper(ArrayList<ArrayList<Integer>> result,TreeNode root,int level){
        if (root == null){
            return;
        }
        if (result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(result,root.left,level+1);
        helper(result,root.right,level+1);
    }


    public int maxDepth (TreeNode root) {
        // write code here
        if (root == null){
            return 0;
        }
        return helper(root,0);
    }

    public int helper(TreeNode root,int level){
        if (root == null){
            return level;
        }
        int left = helper(root.left,level+1);
        int right = helper(root.right,level+1);
        return Math.max(left,right);
    }

    public boolean hasPathSum1 (TreeNode root, int sum) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur!= null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                sum-=cur.val;
                cur = cur.left;
            }
            if (sum == 0 && cur.left == null && cur.right == null){
                return true;
            }
            cur = stack.peek();
            if (cur.right!=null && cur.right != pre){
                cur =cur.right;
            }else {
                cur = stack.pop();
                sum+=cur.val;
                pre = cur;
                cur = null;
            }
        }
        return false;
    }

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root == null || sum == 0){
            return false;
        }
        return helper2(root, sum);
    }

    public boolean helper2(TreeNode root, int sum){

        if (root == null && sum == 0){
            return true;
        }
        if (root == null && sum != 0){
            return false;
        }
        if (root != null && sum == 0){
            return false;
        }
        sum-=root.val;
        return helper2(root.left,sum) || helper2(root.right,sum);
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = cur;
        Boolean isFirst = true;
        TreeNode head = cur;
        while (cur!=null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isFirst){
                head = cur;
                isFirst = false;
            }else {
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        return head;
    }




}
