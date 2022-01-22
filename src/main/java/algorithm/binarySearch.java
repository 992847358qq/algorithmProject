package algorithm;

/**
 * @Author: wgl
 * @Date: 2020/07/20 15:05
 * @Description:
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,7,34,57,89};
        int temp = 57;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (right + left)/2;
            if (nums[mid] == temp){
                System.out.println(mid);
                break;
            }else if (nums[mid]>temp){
                right = mid-1;
            }else if (nums[mid]<temp){
                left = mid+1;
            }
        }
    }
}
