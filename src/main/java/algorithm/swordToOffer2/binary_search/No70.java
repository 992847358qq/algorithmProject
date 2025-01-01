package algorithm.swordToOffer2.binary_search;

/**
 * @description: 排序数组中只出现一次的数字
 * 对数组进行分组，第一个数组中数字不相同，那么第一个数字就是不相同的数字
 * @author: gaoliang.wang
 * @date: 2022/3/9 10:52 PM
 **/
public class No70 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length/2;
        while (left<=right){
            int mid = (left+right)/2;
            //求出中间分组下标
            int i = mid*2;
            if (i<nums.length-1 && nums[i] != nums[i+1]){
                if (mid == 0 || nums[i-2] == nums[i-1]){
                    return nums[i];
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nums[nums.length-1];
    }
}
