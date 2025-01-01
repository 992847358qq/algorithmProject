package algorithm.swordToOffer2.tree;

import algorithm.swordToOffer2.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 向下的路径节点值之和
 * @author: gaoliang.wang
 * @date: 2022/3/1 10:59 PM
 **/
public class No50 {
    public int partSum(TreeNode root,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root,sum,map,0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
        if (root == null){
            return 0;
        }
        path += root.val;
        int count = map.getOrDefault(path-sum,0);
        map.put(path,map.getOrDefault(path,0)+1);
        count+= dfs(root.left,sum,map,path);
        count+= dfs(root.right,sum,map,path);
        //叶子节点递归遍历下探到子节点，当函数结束时，返回到父节点时，需要把到当前子节点的路径删除
        map.put(path,map.get(path)-1);
        return count;
    }
}
