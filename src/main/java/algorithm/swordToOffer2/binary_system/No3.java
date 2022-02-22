package algorithm.swordToOffer2.binary_system;

import java.util.Arrays;

/**
 * @description: 前n个数字二进制形式中1的个数
 * @author: gaoliang.wang
 * @date: 2022-02-08
 **/
public class No3 {
    public static void main(String[] args) {
        //System.out.println(oneNum(10));
        System.out.println(Arrays.toString(countBit(4)));
        System.out.println(Arrays.toString(countBits(4)));
        System.out.println(Arrays.toString(countBits1(4)));
    }

    //求一个整数二进制中有几个1
    public static int oneNum(int num){
        int count = 0;
        while (num!= 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
    //最坏打算整数中可能有k个1，那么时间复杂度为O(nk)
    public static int[] countBit(int num){
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0){
                j = j&(j-1);
                result[i]++;
            }
        }
        return result;
    }

    //由上面推演出来整数i二进制中1的个数比"i&(i-1)"二进制中1的个数多1
    //只根据O(1)的时间就可以求出整数i二进制中1的个数，时间复杂度为O(n)
    public static int[] countBits(int num){
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i&(i-1)] + 1;
        }
        return result;
    }
    //当i为偶数时，i与i/2相比，相当于是把i/2左移1位得到i，i与i/2二进制中1的个数是相同的
    //当i为奇数时，i与i/2相比，相当于是把i/2左移1位后，个位即右边最后一位+1，所以i比i/2二进制中1的个数多1
    public static int[] countBits1(int num){
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i&1);
        }
        return result;
    }
}
