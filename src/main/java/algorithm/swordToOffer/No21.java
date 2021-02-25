package algorithm.swordToOffer;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept  调整数组顺序使奇数位于偶数前面
 * @description TODO
 * @date 2021/2/12 19:27
 **/
public class No21 {
    public static void main(String[] args) {
        int[] array = new int[]{3,7,4,8,23,56,77,89,46,11,66,77};
        sortArr(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sortArr(int[] array) {
        if (array.length == 0){
            return;
        }
        int left = 0 ;
        int right = array.length -1 ;
        while (left<right){
            while (left<right && !isEven(array[left])){
                left++;
            }
            while (left<right && isEven(array[right])){
                right--;
            }
            if (left<right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            if (left>= right){
                break;
            }
        }
    }
    public static boolean isEven(int num){
        return (num & 1) == 0;
    }
}
