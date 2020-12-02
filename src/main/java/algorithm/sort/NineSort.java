package algorithm.sort;

import java.util.Arrays;

/**
 * @Author: wgl
 * @Date: 2020/07/20 14:04
 * @Description:
 */
public class NineSort {
    public static void main(String[] args) {
        int[] nums = new int[]{87,234,53,23,1,43};
        int len = nums.length;
        selectSort(nums,len);
    }

    public static void selectSort(int[] nums , int len){
        for (int i = 0;i<len-1;i++){
            int j = i;
            for (int k =i+1;k<len;k++){
                if (nums[j]>nums[k]){
                    j=k;
                }
            }
            if (j!=i){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println("选择排序："+Arrays.toString(nums));
    }

}
