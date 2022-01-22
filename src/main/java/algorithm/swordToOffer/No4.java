package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从
 *  * 上到下递增的顺序排序，请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * @description TODO
 * @date 2021/1/22 23:17
 **/
public class No4 {
    public static void main(String[] args) {
        int [][] arr= new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(arr,7));
    }

    private static boolean find(int[][] arr, int i) {
        if (arr == null ){
            return false;
        }
        int column = arr[0].length-1;
        int row = 0;
        while (row<arr.length && column>0){
            //每次与最右上角数字对比
            if (i == arr[row][column]){
                return true;
            }
            if (i<arr[row][column]){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
}
