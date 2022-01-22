package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/23 23:59
 **/
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
