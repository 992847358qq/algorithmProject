package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept 求无序数组排序后的任意两个相邻元素的最大差值
 * @description TODO
 * @date 2021/1/13 23:33
 **/
public class QueFive {
    class Bucket{
        Integer min;
        Integer max;
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max<arr[i]){
                max = arr[i];
            }
            if (min>arr[i]){
                min = arr[i];
            }
        }
        int diff = max - min;
        if (diff == 0){
            return 0;
        }
        //初始化桶

        //遍历原始数组，确定每个桶的最大最小值
        //遍历桶，找到最大差值
        return 0;
    }
}
