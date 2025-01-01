package algorithm.niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 最长无重复子数组
 * @author: gaoliang.wang
 * @date: 2022/5/3 11:43 PM
 **/
public class Bm92 {
    public static void main(String[] args) {
        System.out.println(new Bm92().maxLength(new int[]{2,2,3,4,8,99,3}));
    }
    public int maxLength (int[] arr) {
        // write code here
        int left = 0, right = 0, max = 0;
        Set<Integer> set = new HashSet<>();
        while (right < arr.length) {
            if (set.contains(arr[right])) {
                set.remove(arr[left++]);
            } else {
                set.add(arr[right++]);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
