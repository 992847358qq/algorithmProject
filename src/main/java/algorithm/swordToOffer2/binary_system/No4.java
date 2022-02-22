package algorithm.swordToOffer2.binary_system;

/**
 * @description: 只出现一次的数字，给一个数组，里面整数数字都出现三次，只有一个出现一次，返回出现一次的数字
 * @author: gaoliang.wang
 * @date: 2022-02-09
 **/
public class No4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,8,7,1,3,5,8,1,3,5,8};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
    }

    //所有数字二进制相加，然后每位除以3，如果余数是0就是0，如果余数是1就是1
    public static int singleNumber(int[] nums){
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (nums[i] >> (31-j)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bits[i]%3;
        }
        return result;
    }


    public static int singleNumber1(int[] nums){
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 31; j >= 0; j--) {
                bits[j] += (nums[i] >> (j)) & 1;
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = (result << 1) + bits[i]%3;
        }
        return result;
    }

    //同理可以解决输入一个整数数组，数组中只有一个数字出现m次，其他数字都出现n次，求那个唯一出现m次的数字。
    //如果数组中所有数字的第i个数位相加能被n整除，那么出现m次的数字的第i个数位一定为0
    //如果不能整除，则为1


}
