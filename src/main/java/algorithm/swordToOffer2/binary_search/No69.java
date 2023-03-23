package algorithm.swordToOffer2.binary_search;

/**
 * @description: 山峰数组的顶部
 * @author: gaoliang.wang
 * @date: 2022/3/9 10:35 PM
 **/
public class No69 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,2,0};
        new No69().peakIndexInMountainArray(arr);
    }
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3){
            return -1;
        }
        int left = 1;
        int right = arr.length -2;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (arr[mid] > arr[mid-1]){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
