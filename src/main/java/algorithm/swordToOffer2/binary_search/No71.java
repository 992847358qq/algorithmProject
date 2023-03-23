package algorithm.swordToOffer2.binary_search;

import java.util.Random;

/**
 * @description: 按权重生成随机数
 * @author: gaoliang.wang
 * @date: 2022/3/10 12:11 AM
 **/
public class No71 {

    public int[] nums;
    public int total;

    public No71(int[] w) {
        this.nums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total+=w[i];
            nums[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(total);
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]>p){
                if (mid == 0 || nums[mid-1] <= p){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
