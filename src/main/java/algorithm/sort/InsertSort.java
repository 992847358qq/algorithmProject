package algorithm.sort;

import java.util.Arrays;

/**
 * @Author: wgl
 * @Date: 2020/07/17 18:39
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{87,234,53,23,1,43};
        for (int i = 1;i<nums.length;i++){
            int temp = nums[i];
            int j = i;
            while (j>0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void test(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            //前面一位比当前值大，前值后推一位
            while (j>0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
                //循环忘前比
                j--;
            }
            //当比前一个值大时，插入到当前位置
            nums[j] = temp;
        }
    }
}
