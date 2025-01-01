package algorithm.swordToOffer2.sort;

import java.util.Arrays;

/**
 * @description: 计数排序-数组相对排序
 * @author: gaoliang.wang
 * @date: 2022/3/12 1:43 PM
 **/
public class No75 {
    public static void main(String[] args) {
        No75 no75 = new No75();
        int[] nums = new int[]{2,3,4,2,3,2,1};
        System.out.println(Arrays.toString(no75.sortArray(nums)));
        System.out.println(Arrays.toString(no75.sortArray1(nums)));
    }


    //计数排序
    //数组长度为n，整数范围为k，所以时间复杂度为O(n+k)
    //创建一个长度为k的数组，空间复杂度为O(k)
    public int[] sortArray(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num:nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int[] counts = new int[max-min+1];
        for (int num:nums){
            counts[num-min]++;
        }
        int i = 0;
        for (int j = min; j <= max; j++) {
            while (counts[j-min]>0){
                nums[i++] = j;
                counts[j-min]--;
            }
        }
        return nums;
    }

    public int[] sortArray1(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num:nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int[] counts = new int[max+1];
        for (int num:nums){
            counts[num]++;
        }
        int i = 0;
        for (int j = 0; j < counts.length; j++) {
            while (counts[j]>0){
                nums[i++] = j;
                counts[j]--;
            }
        }
        return nums;
    }
    //空间复杂度为O(1)
    //arr1长度为m，are2长度为n，时间复杂度为O(m+n)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num:arr1){
            counts[num]++;
        }
        int i = 0;
        for (int num:arr2) {
            while (counts[num]>0){
                arr1[i++] = num;
                counts[num]--;
            }
        }
        for (int j = 0; j < counts.length; j++) {
            while (counts[j]>0){
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}
