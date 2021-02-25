package algorithm.sort;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/4 22:37
 **/
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = new int[]{2,3,4,5,6,7,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void QuickSortTest(int[] arr,int start,int end){
        if (start<end){
            //获取数组中坐标为start的值作为标准基数
            int index = arr[start];
            int low = start;
            int high = end;
            while (low<high){
                while (high>low && index<=arr[high]){
                    high--;
                }
                arr[low] = arr[high];
                while (high>low && arr[low]<=index){
                    low++;
                }
                arr[high] = arr[low];
            }
            //重合赋值标准数
            arr[low]=index;
            //处理所有小的数字
            QuickSortTest(arr,start,low);
            //处理所有大的数字
            QuickSortTest(arr,low+1,end);

        }

    }
    public static void quickSort(int[] arr, int startIndex, int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);

    }
    private static int partition(int[] arr, int startIndex, int endIndex){
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left<right && arr[right]>pivot){
                right--;
            }
            while (left<right && arr[left] <= pivot){
                left++;
            }
            if (left<right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
