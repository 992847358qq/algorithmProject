package algorithm.swordToOffer2.binary_search;

/**
 * @description: 查找插入位置
 * @author: gaoliang.wang
 * @date: 2022/3/9 10:29 PM
 **/
public class No68 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]>=target){
                if (mid == 0 || nums[mid-1]<target){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nums.length;
    }
}
