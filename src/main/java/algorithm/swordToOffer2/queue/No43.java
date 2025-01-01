package algorithm.swordToOffer2.queue;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 在完全二叉树中添加节点
 * @author: gaoliang.wang
 * @date: 2022/2/27 7:19 PM
 **/
public class No43 {



    class CBTInserter{
        public Queue<TreeNode> queue;
        public TreeNode root;

        public CBTInserter(TreeNode root){
            this.root = root;
            queue = new LinkedList<>();
            queue.offer(root);
            while (queue.peek().left != null && queue.peek().right != null){
                TreeNode poll = queue.poll();
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }

        public int insert(int v){
            TreeNode parent = queue.peek();
            TreeNode node = new TreeNode(v);
            if (parent.left == null){
                parent.left = node;
            }else {
                parent.right = node;
                queue.poll();
                queue.offer(parent.left);
                queue.offer(parent.right);
            }
            return parent.val;
        }
    }
}
