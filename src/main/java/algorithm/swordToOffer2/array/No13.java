package algorithm.swordToOffer2.array;

/**
 * @description: 二维子矩阵的数字之和
 * @author: gaoliang.wang
 * @date: 2022-02-13
 **/
public class No13 {
    private  int[][] nums;

    public static void main(String[] args) {
        int[][] mattrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        No13 no13 = new No13(mattrix);
        System.out.println(no13.sumRegion(0,0,1,1));
    }

    public No13(int[][] mattrix){
        if (mattrix.length == 0 || mattrix[0].length == 0){
            return;
        }
        nums = new int[mattrix.length+1][mattrix[0].length+1];
        for (int i = 0; i < mattrix.length; i++) {
            int rowNum = 0;
            for (int j = 0; j < mattrix[0].length; j++) {
                rowNum+= mattrix[i][j];
                //坐标(i,j) 可以看做(i-1,j) 轮着加第i行数字
                //当i为0时，i-1会数组越界。所以nums数组多加了一行、一列
                //所以坐标(i,j)实际算的(i+1,j+1)的值
                nums[i+1][j+1] = nums[i][j+1] + rowNum;
            }
        }
    }

    /**
     * 转换公式sums[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1]
     */
    public  int sumRegion(int row1,int col1,int row2,int col2){
        return nums[row2+1][col2+1] - nums[row1][col2+1]-
                nums[row2+1][col1] + nums[row1][col1];
    }


}
