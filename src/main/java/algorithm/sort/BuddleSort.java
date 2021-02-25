package algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/3 19:50
 **/
public class BuddleSort {
    public static void main(String[] args) {
        int [] arr = new int[]{2,3,4,5,6,7,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;
        for (int i = 0;i<arr.length-1;i++){
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //因为有元素进行比较，所以不是有序的，标记变为false;
                    isSorted = false;
                    //更新为最后一次交换元素的位置;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
    //鸡尾酒排序
    public static void sort1(int[] arr){
        for (int i = 0;i<arr.length/2;i++){
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //基数轮从左到右比较和交换
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //因为有元素进行比较，所以不是有序的，标记变为false;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            //偶数轮比较前重新标记为true
            isSorted = true;
            for (int j = arr.length-i-1; j < i; j--) {
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j+1] = temp;
                    //因为有元素进行比较，所以不是有序的，标记变为false;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }
}
