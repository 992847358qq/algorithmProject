package tree;

import java.util.List;

/**
 * @author GaoLiang.Wang
 * @dept 上海软件研发中心
 * @description TODO
 * @date 2019/11/17 16:11
 **/
public class BinaryTree {
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 创建二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(List inputList){
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()){
            return  null;
        }
        Integer data = (Integer)inputList.remove(0);
        if (data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.leftChild = createBinaryTree(inputList);
        }
        return node;
    }
     public static void preOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
     }
}
