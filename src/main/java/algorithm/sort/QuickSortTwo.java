package algorithm.sort;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/5 21:14
 **/
public class QuickSortTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,8,2,6,5,4,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr , int start,int end){
        if (start>=end){
            return;
        }
        //得到基准元素位置
        int index = partition(arr,start,end) ;
        quickSort(arr,0,index-1);
        quickSort(arr,index+1,end);
    }
    public static int partition(int[] arr,int start,int end){
        //取第一个值作为基准元素
        int pivot = arr[start];
        int mark = start;
        for (int i = start+1; i <= end; i++) {
            if (arr[i]<pivot){
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
