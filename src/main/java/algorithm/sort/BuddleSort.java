package algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wgl
 * @Date: 2020/07/17 18:08
 * @Description:
 */
public class BuddleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{87,234,53,23,1,43};
        //从小到大
       /* for (int i=0; i<nums.length-1;i++){
            for (int j =0;j<nums.length-1-i;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }*/
        //从大到小
        for (int i=0; i<nums.length-1;i++){
            for (int j =nums.length-1;j>i;j--){
                if (nums[j]>nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
