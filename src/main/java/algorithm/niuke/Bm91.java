package algorithm.niuke;

/**
 * @description: 矩阵最长递增路径
 * @author: gaoliang.wang
 * @date: 2022/4/28 11:02 PM
 **/
public class Bm91 {
    public int solve (int[][] matrix) {
        // write code here
        int row = matrix.length;
        if (matrix == null || row == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int col = matrix[0].length;
        int len = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //从左上角开始
                max = Math.max(max,helper(matrix,i,j,len));
            }
        }
        return max;
    }

    private int helper(int[][] matrix, int i, int j,int len) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = len;
        //左
        if (j-1>=0 && matrix[i][j]<matrix[i][j-1]){
            max = Math.max(max,helper(matrix,i,j-1,len+1));
        }
        //右
        if (j+1<col && matrix[i][j]<matrix[i][j+1]){
            max = Math.max(max,helper(matrix,i,j+1,len+1));
        }
        //上
        if (i-1>=0 && matrix[i][j]<matrix[i-1][j]){
            max = Math.max(max,helper(matrix,i-1,j,len+1));
        }
        //下
        if (i+1<row && matrix[i][j]<matrix[i+1][j]){
            max = Math.max(max,helper(matrix,i+1,j,len+1));
        }
        return max;
    }
}
