package algorithm.question.greedy;

import java.util.Arrays;

/**
 * @description: Easy
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩
 * 子可以吃饱。
 * 输入两个数组，分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数
 * 量。
 * Input: [1,2], [1,2,3]
 * Output: 2
 * 题解
 * 因为饥饿度最小的孩子最容易吃饱，所以我们先考虑这个孩子。为了尽量使得剩下的饼干可
 * 以满足饥饿度更大的孩子，所以我们应该把大于等于这个孩子饥饿度的、且大小最小的饼干给这
 * 个孩子。满足了这个孩子之后，我们采取同样的策略，考虑剩下孩子里饥饿度最小的孩子，直到
 * 没有满足条件的饼干存在。
 * @author: gaoliang.wang
 * @date: 2022/10/18 11:14 PM
 **/
public class Num1 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{1,2,3};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int child = 0, cookie = 0;
        while (child < arr1.length && cookie < arr2.length) {
            if (arr1[child] <= arr2[cookie]) ++child;
            ++cookie;
        }
        System.out.println(child);
    }
}
