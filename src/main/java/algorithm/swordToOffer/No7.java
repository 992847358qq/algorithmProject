package algorithm.swordToOffer;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept 重建二叉树，
 * 前序遍历序列：12473568
 * 中序遍历序列：47215386
 * @description TODO
 * @date 2021/1/24 0:01
 **/
public class No7 {
    public static void main(String[] args) throws Exception {
        int preSort[] = {1,2,4,7,3,5,6,8};
        int inSort[] = {4,7,2,1,5,3,8,6};
        TreeNode root=constructCore(preSort,inSort);
        System.out.println(root.data);
    }

    private static TreeNode constructCore(int[] preSort, int[] inSort) throws Exception {
        if (preSort == null && inSort == null){
            return null;
        }
        if (preSort.length != inSort.length){
            throw  new Exception("数组长度不一致");
        }
        TreeNode root = new TreeNode();
        for (int i = 0; i < inSort.length; i++) {
            if (preSort[0] == inSort[i]){
                root.data = inSort[i];
                System.out.println(root.data);
                root.left = constructCore(Arrays.copyOfRange(preSort,1,i+1),
                                          Arrays.copyOfRange(inSort,0,i));
                root.right = constructCore(Arrays.copyOfRange(preSort,i+1,preSort.length),
                                            Arrays.copyOfRange(inSort,i+1,inSort.length));
            }
        }
        return root;
    }
}
