package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组
 * 的一个旋转，输出旋转数组的最小元素。例如数组
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。
 * @description TODO
 * @date 2021/1/31 18:44
 **/
public class No11 {
    public static void main(String[] args) {
        //int[] arr={3,4,5,1,2};
        int[] arr={1,0,1,1,1};
        System.out.println(findMin(arr));
    }
    static int findMin(int [] arr){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        if (arr[start]<arr[end]){
            try{
                throw new Exception("非旋转数组");
            } catch(Exception e){
              e.printStackTrace();
              return -1;
            }
        }
        while (start<end){
            mid = (start+end)/2;
            //对于{1,0,1,1,1}之类的特殊处理
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
                return searchMin(arr,start,end);
            }
            if (end-start == 1){
                mid = end;
                break;
            }
            if (arr[mid] >=arr[start]){
                start = mid;
            }else {
                end = mid;
            }
        }
        return arr[mid];
    }

    private static int searchMin(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start+1; i < arr.length; i++) {
            if (arr[i]<result){
                result = arr[i];
            }
        }
        return result;
    }
}
