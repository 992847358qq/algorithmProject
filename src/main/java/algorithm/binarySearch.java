package algorithm;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/5 22:10
 **/
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int start = 0;
        int end = arr.length-1;
        int index = 2;
        while (start<= end){
            int mid = (start+end)/2;
            if (index == arr[mid]){
                System.out.println(mid);
                return;
            }else if (index>arr[mid]){
                start = mid+1;
            }else if (index<arr[mid]){
                end = mid-1;
            }
        }
        System.out.println(-1);
    }
}
