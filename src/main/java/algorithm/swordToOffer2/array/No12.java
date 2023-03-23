package algorithm.swordToOffer2.array;

/**
 * @description: 左右两边子数组的和相同
 * 假如数组下标i两边的子数组和相同，也就是 0~(i-1)之间的和  与 (i+1)~数组长度 之间的和相同
 * 那么这个和就等于 数组的和 减去 (0~i之间的和)
 * 所以只需要算出，当第i个数字时，数组整体和 - 累加到第i个数字的和   == 数字第0个到第i-1个数字之间的和
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No12 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,2,9};
        System.out.println(pivotIndex(nums));
    }

    //1 2 3 2 1

    public static int pivotIndex(int [] nums){
        int total = 0;
        for (int num:nums){
            total+=num;
        }
        int result = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum-nums[i] == total-sum){
                return i;
            }
        }
        return result;
    }
}
