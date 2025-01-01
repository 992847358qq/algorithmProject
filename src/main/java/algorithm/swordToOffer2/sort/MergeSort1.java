package algorithm.swordToOffer2.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/13 1:32 AM
 **/
public class MergeSort1 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,5,6,2,7,8,3};
        int[] ints = new MergeSort1().sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums){
        int[] dst = new int[]{nums.length};
        dst = Arrays.copyOf(nums,nums.length);
        mergeSort(nums,dst,0,nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start+1>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(dst,src,start,mid);
        mergeSort(dst,src,mid,end);
        int i=start,j=mid,k=start;
        while (i<mid || j<end){
            if (j == end || (i<mid && src[i]<src[j])){
                dst[k++] = src[i++];
            }else {
                dst[k++] = src[j++];
            }
        }
    }
}
