package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 二叉树的下一个节点，给定一个二叉树和其中的一个节点，找出中序遍历序列的下一个节点
 * @description TODO
 * @date 2021/1/24 22:00
 **/
public class No8 {
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
        twenty_two.left = twenty_one;
        twenty_one.left = sixth;
        sixth.left = seventh;
        sixth.right = eightth;
        eightth.right = nineth;

        twenty_two.right = twenty_three;
        twenty_three.right = twenty_five;
        twenty_five.left = twenty_four;
        twenty_five.right = twenty_six;
        inOrderTraveral(twenty_five); //17 16 18 19 21 22 23 24 25 26
        /*System.out.println();
        System.out.println(getNextNode(twenty_two).data);*/
    }

    public static TreeNode getNextNode(TreeNode treeNode){
        if (treeNode == null){
            return null;
        }
        TreeNode nextNode;
        if ((nextNode =treeNode.left) != null){
            while (nextNode.getLeft() != null){
                nextNode = nextNode.getLeft();
            }
            //右节点判断缺省，需要判断父类
        }else if ((nextNode = treeNode.getRight()) != null){
            while (nextNode.getLeft() != null){
                nextNode = nextNode.getLeft();
            }
        }
        return nextNode;
    }

    public static void inOrderTraveral(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        inOrderTraveral(treeNode.left);
        System.out.print(treeNode.data+" ");
        inOrderTraveral(treeNode.right);
    }
}
