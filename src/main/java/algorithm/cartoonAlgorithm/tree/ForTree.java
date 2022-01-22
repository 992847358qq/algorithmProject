package algorithm.cartoonAlgorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/8 21:12
 **/
public class ForTree {
    /*public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4})
        );
        TreeNode treeNode = createBinatyTree(inputList);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println();
        System.out.println("后序遍历");
        postOrderTraveral(treeNode);
    }*/
    public static void main(String[] args) {
        TreeNode twenty_two = new TreeNode(22);
        TreeNode twenty_one = new TreeNode(21);
        TreeNode twenty_three = new TreeNode(23);
        TreeNode sixth = new TreeNode(16);
        TreeNode twenty_five = new TreeNode(25);
        TreeNode twenty_four = new TreeNode(24);
        TreeNode twenty_six = new TreeNode(26);
        TreeNode seventh = new TreeNode(17);
        TreeNode eightth = new TreeNode(18);
        TreeNode nineth = new TreeNode(19);
        twenty_two.leftTree = twenty_one;
        twenty_one.leftTree = sixth;
        sixth.leftTree = seventh;
        sixth.rightTree = eightth;
        eightth.rightTree = nineth;

        twenty_two.rightTree = twenty_three;
        twenty_three.rightTree = twenty_five;
        twenty_five.leftTree = twenty_four;
        twenty_five.rightTree = twenty_six;

        System.out.println("递归前序遍历");
        preOrderTraveral(twenty_two);
        System.out.println();
        System.out.println("递归中序遍历");
        inOrderTraveral(twenty_two);
        System.out.println();
        System.out.println("递归后序遍历");
        postOrderTraveral(twenty_two);
        System.out.println();

        /*System.out.println("非递归前序遍历");
        preOrderStack(twenty_two);
        System.out.println();
        System.out.println("非递归中序遍历");
        midOrderStack(twenty_two);
        System.out.println();
        System.out.println("非递归后序遍历");
        postOrderStack(twenty_two);*/
    }
    //非递归前序遍历
    public static void preOrderStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftTree;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightTree;
            }
        }
    }
    //非递归中序遍历
    public static void midOrderStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.leftTree;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightTree;
            }
        }
    }
    //后序遍历
    public static void postOrderStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        //记录上一个访问的节点
        TreeNode pre = null;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.leftTree;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                treeNode = stack.peek();
                if (treeNode.rightTree == null || treeNode.rightTree == pre){
                    //弹出栈顶元素
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    //标记上一次访问的节点
                    pre = treeNode;
                    treeNode = null;
                }else {
                    treeNode = treeNode.rightTree;
                }
            }
        }
    }
    public static TreeNode createBinatyTree(LinkedList<Integer> inputList){
        TreeNode treeNode = null;
        if (inputList == null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data!= null){
            treeNode=new TreeNode(data);
            treeNode.leftTree = createBinatyTree(inputList);
            treeNode.rightTree = createBinatyTree(inputList);
        }
        return treeNode;
    }
    private static class TreeNode{
        int data;
        TreeNode leftTree;
        TreeNode rightTree;
        public TreeNode(int data){
            this.data = data;
        }
    }
    //前序遍历
    public static void preOrderTraveral(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.print(treeNode.data+" ");
        preOrderTraveral(treeNode.leftTree);
        preOrderTraveral(treeNode.rightTree);
    }
    //中序遍历
    public static void inOrderTraveral(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        inOrderTraveral(treeNode.leftTree);
        System.out.print(treeNode.data+" ");
        inOrderTraveral(treeNode.rightTree);
    }
    //后序遍历
    public static void postOrderTraveral(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postOrderTraveral(treeNode.leftTree);
        postOrderTraveral(treeNode.rightTree);
        System.out.print(treeNode.data+" ");
    }
}
