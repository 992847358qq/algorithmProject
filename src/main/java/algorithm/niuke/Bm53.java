package algorithm.niuke;

/**
 * @description: 缺失的第一个正整数
 * @author: gaoliang.wang
 * @date: 2022/4/24 11:07 PM
 **/
public class Bm53 {
    public int minNumberDisappeared (int[] nums) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0){
                arr[nums[i]] = 1;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == 0){
                return i;
            }
        }
        if (arr[0] == 1){
            return nums.length;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,3,7,5,2,6,4};
        new Bm53().minNumberDisappeared1(nums);
    }

    public int minNumberDisappeared1 (int[] nums) {
        int n = nums.length;
        //遍历数组
        for(int i = 0; i < n; i++){
            //负数全部记为n+1
            if(nums[i] <= 0)
                nums[i] = n + 1;
        }

        for(int i = 0; i < n; i++){
            //对于1-n中的数字
            if(Math.abs(nums[i]) <= n)
                //这个数字的下标标记为负数
                nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        for(int i = 0; i < n; i++){
            //找到第一个元素不为负数的下标
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
