package algorithm.swordToOffer2.array;

/**
 * @description: 和大于或等于k的最短子数组
 * 输入数组[5,1,4,3]，k的值为7，取大于或等于7的最短连续子数组是[4,3]，因此输出长度为2
 * @author: gaoliang.wang
 * @date: 2022-02-11
 **/
public class No8 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,4,3};
        int k = 7;
        System.out.println(minSubArrayLen(nums,k));
    }

    public static int minSubArrayLen(int[] nums,int k){
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right <nums.length ; right++) {
            sum += nums[right];
            while (left<=right && sum >=k){
                minLength = Math.min(minLength,right-left+1);
                sum -= nums[left++];
            }
        }
        return minLength;
    }
}
