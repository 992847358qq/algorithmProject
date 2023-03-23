package algorithm.niuke;

/**
 * @description: 寻找第k大
 * @author: gaoliang.wang
 * @date: 2022/4/23 11:49 PM
 **/
public class Bm47 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a,0,n-1);
        return a[n-K];
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
