package algorithm.cartoonAlgorithm.heap;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept 最小堆
 * @description TODO
 * @date 2021/1/9 21:53
 **/
public class MinHeap {
    /**
     * 上浮调整
     */
    public static void upAdjust(int[] arr){
        //获取最后一个节点
        int childIndex = arr.length-1;
        //父节点
        int parentIndex = (childIndex-1)/2;
        //保存插入的叶子节点值，用于最后赋值
        int temp = arr[childIndex];
        while (childIndex >0 && temp<arr[parentIndex]){
            //小于，父节点赋值给子节点
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        arr[childIndex] = temp;
    }
    /**
     * 下沉操作
     */
    public static void downAdjust(int[] arr,int parentIndex,int length){
        int temp =arr[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex <length){
            if (childIndex+1<length && arr[childIndex+1]<arr[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个子节点值，则直接跳出
            if (temp<=arr[childIndex]){
                break;
            }
            arr[parentIndex]=arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        arr[parentIndex] = temp;

    }
    /**
     * 构建堆
     */
    public static void buildHeap(int[] arr){
        for (int i = (arr.length-2)/2;i>=0;i--){
            downAdjust(arr,i,arr.length);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
