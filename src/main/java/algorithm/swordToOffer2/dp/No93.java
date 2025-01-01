package algorithm.swordToOffer2.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最长斐波那契队列
 * @author: gaoliang.wang
 * @date: 2022/3/25 11:04 PM
 **/
public class No93 {
    /**
     * 存在数组A下标为k,j,i，k<j<i，三个元素组成斐波那契数列
     * 这个以A[i]结尾，前一个数字为A[j]的斐波那契数列是在以A[j]为结尾，前一个数字时A[k]的斐波那契队列的
     * 基础上加上A[i]，因此前者的长度是在后者长度的基础上加1
     * f(j,k)表示以j结尾，前一个数字是k的长度
     * 那么f(i,j) = f(j,k)+1
     * 创建一个二维数组行表示i，列表示j
     * 最小长度为2，但不是斐波那契数列
     */
    public int lenLongestFibSubseq(int[] arr) {
        //map用来存储数组值及其下标
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int result = 2;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i]-arr[j],-1);
                dp[i][j] = k>=0 && k<j?dp[j][k]+1:2;
                result = Math.max(result,dp[i][j]);
            }
        }
        return result>2?result:0;
    }
}
