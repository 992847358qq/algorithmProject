package algorithm.swordToOffer2.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/12 11:38 PM
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,5,6,2,7,8,3};
        int[] dst = new int[nums.length];
        new MergeSort().sort(nums,0,nums.length-1,dst);
        System.out.println(Arrays.toString(nums));
    }


    public int[] mergeSort(int[] nums){
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length ; seg+=seg) {
            for (int start = 0; start < length ; start+=seg*2) {
                int mid = Math.min(start+seg,length);
                int end = Math.min(start+seg*2,length);
                int i = start,j = mid,k = start;
                while (i<mid || j<end){
                    if (j == end || (i<mid && src[i]<src[j])){
                        dst[k++] = src[i++];
                    }else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;
    }


    public int[] mergeSort1(int[] nums){
        int length = nums.length;
        int[] dst = new int[length];
        for (int seg = 1; seg < length ; seg+=seg) {
            for (int start = 0; start < length ; start+=seg*2) {
                int left = start;
                int right = start+seg*2;
                int mid = (left+right)/2;
                int j = mid;
                int i = start;
                while (left<mid && j<right){
                    if (nums[i]<nums[j]){
                        dst[left++] = nums[i++];
                    }else {
                        dst[left++] = nums[j++];
                    }
                }
                while (i<mid){
                    dst[left++] = nums[i++];
                }
                while (j<right){
                    dst[left++] = nums[j++];
                }
            }
            int[] temp = nums;
            nums = dst;
            dst = temp;
        }
        return nums;
    }


    public  void sort(int[] arr,int left,int right,int[] nums){
        if  (left<right){
            int mid = (left+right)/2;
            //左边归并排序，使得左子序列有序
            sort(arr,left,mid,nums);
            //右边归并排序，使得右子序列有序
            sort(arr,mid+1,right,nums);
            //将两个有序子数组合并操作
            merge(arr,left,mid,right,nums);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左子序列指针
        int j = mid+1;//右子序列指针
        int t = 0;
        while (i<=mid && j<=right){
            if (arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
