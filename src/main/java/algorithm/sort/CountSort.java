package algorithm.sort;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/10 21:41
 **/
public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,4,6,7,3,8,2,1,1,0,9,10,6};
        int[] sortArr = countSort(array);
        System.out.println(Arrays.toString(sortArr));
    }
    public static int[] countSort(int[] arr){
        //求出最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                 max = arr[i];
            }
        }
        int[] countArr = new int[max+1];
        for (int i = 0;i<arr.length;i++){
            countArr[arr[i]] +=1;
        }
        //遍历统计数组，输出结果
        int[] result = new int[arr.length];
        int index = 0;
        for (int i =0;i<countArr.length;i++){
            for (int j = 0;j<countArr[i];j++){
                result[index++] = i;
            }
        }
        return result;
    }
}
