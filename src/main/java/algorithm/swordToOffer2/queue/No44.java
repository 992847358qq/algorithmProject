package algorithm.swordToOffer2.queue;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树中每层的最大值
 * @author: gaoliang.wang
 * @date: 2022/2/27 8:51 PM
 **/
public class No44 {

    public List<Integer> largestValue(TreeNode treeNode){
        int current = 0;
        int next = 0;
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        if (treeNode != null){
            queue.offer(treeNode);
            current++;
        }

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            current--;
            max = Math.max(max,poll.val);


            if (poll.left != null){
                queue.offer(poll.left);
                next++;
            }

            if (poll.right != null){
                queue.offer(poll.right);
                next++;
            }

            if (current == 0){
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    //使用两个队列来实现
    public List<Integer> largestValue1(TreeNode treeNode){
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (treeNode != null){
            queue1.offer(treeNode);
        }

        while (!queue1.isEmpty()){
            TreeNode poll = queue1.poll();
            max = Math.max(max,poll.val);


            if (poll.left != null){
                queue2.offer(poll.left);
            }

            if (poll.right != null){
                queue2.offer(poll.right);
            }

            if (queue1.isEmpty()){
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}
