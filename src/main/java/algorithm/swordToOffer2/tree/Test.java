package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.Stack;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023/3/27 12:37 AM
 **/
public class Test {
    //中序遍历：4、2、5、1、6、3、7
    //前序遍历：1、2、4、5、3、6、7
    //后序遍历：4、5、2、6、7、3、1
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        //preOrderDfs(node1);
        //preOrder(node1);
        //midOrderDfs(node1);
        //midOrder(node1);
        //postOrderDfs(node1);
        postOrder(node1);
    }
    //前序遍历：1、2、4、5、3、6、7
    private static void preOrderDfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.println(treeNode.val);
        preOrderDfs(treeNode.left);
        preOrderDfs(treeNode.right);

    }
    //前序遍历：1、2、4、5、3、6、7
    private static void preOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = treeNode;
        while (cur!= null || !stack.isEmpty()){
            while (cur != null){
                System.out.println(cur.val);
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    //中序遍历：4、2、5、1、6、3、7
    public static void midOrderDfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        midOrderDfs(treeNode.left);
        System.out.println(treeNode.val);
        midOrderDfs(treeNode.right);
    }

    public static void midOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = treeNode;
        while (cur!= null || !stack.isEmpty()){
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static void postOrderDfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postOrderDfs(treeNode.left);
        postOrderDfs(treeNode.right);
        System.out.println(treeNode.val);

    }

    //后序遍历：4、5、2、6、7、3、1
    public static void postOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = treeNode;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre){
                cur = cur.right;
            }else {
                stack.pop();
                pre = cur;
                System.out.println(cur.val);
                cur = null;
            }
        }
    }

}
