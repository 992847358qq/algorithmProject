package algorithm.swordToOffer2.sort;

import static algorithm.swordToOffer2.sort.QuickSort.partition;

/**
 * @description: 数组中第k大的数字
 * 数组中第k大的数字的下标为(数组长度n)-k
 * 使用快排对数组排序，如果中间值=n-k，即为第k的数字。
 * 如果中间值>n-k，则k大的数字在左边
 * 如果中间值<n-k，则k大的数字在右边
 * @author: gaoliang.wang
 * @date: 2022/3/12 4:44 PM
 **/
public class No76 {

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        int start = 0;
        int end = nums.length-1;
        int index = partition(nums,start,end);
        while (index!=target){
            if (index>target){
                end = index-1;
            }else {
                start = index+1;
            }
            index = partition(nums,start,end);
        }
        return nums[index];
    }

}
