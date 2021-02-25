package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 找出数组中重复的数字
 * @description TODO
 * @date 2021/1/22 21:40
 **/
public class No3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,0,3,6,5,6,7};
        searchRepeatNum(arr);
    }
    public static void searchRepeatNum(int [] arr){
        for (int i = 0;i<arr.length;i++){
            while (arr[i]!=i){
                //数组里某个数字为5，就把5放到角标5的位置
                // 判断arr[i]所对应的角标arr[arr[i]]相同，则为重复
                if (arr[i] == arr[arr[i]]){
                    System.out.println(arr[i]);
                    break;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
    }
}
