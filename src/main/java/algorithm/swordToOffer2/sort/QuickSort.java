package algorithm.swordToOffer2.sort;


import java.util.Arrays;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/12 3:04 PM
 **/
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{3,5,9,4,22,14,8};
        quickSort.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }



    public void quickSort(int nums[],int start,int end){
        if (end>start){
           int pivot =  partition(nums,start,end);
           quickSort(nums,0,pivot-1);
           quickSort(nums,pivot+1,end);
        }
    }

    public static int partition(int nums[],int start,int end){
        //以首位作为标志值
        int pivot = nums[start];
        int mark = start;
        for (int i = start+1; i <=end ; i++) {
            if (nums[i]<pivot){
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[mark];
        nums[mark]= pivot;
        return mark;
    }
}
