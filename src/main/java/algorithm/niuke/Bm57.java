package algorithm.niuke;

/**
 * @description: 岛屿数量
 * @author: gaoliang.wang
 * @date: 2022/4/28 9:35 PM
 **/
public class Bm57 {
    public int solve (char[][] grid) {
        // write code here
        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = grid[0].length;
        //计算岛屿数量
        int count = 0;
        //从最左上角开始，查找等于1的岛
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //先确定边界值
        int row = grid.length;
        int col = grid[0].length;
        //把当前岛变为0，然后查找上下左右，存在岛也都变为0，直到全为0返回
        grid[i][j] = '0';
        //上
        if (i-1>=0 && grid[i-1][j] == '1'){
            dfs(grid,i-1,j);
        }
        //下
        if (i+1<row && grid[i+1][j] == '1'){
            dfs(grid,i+1,j);
        }
        //左
        if (j-1>=0 && grid[i][j-1] == '1'){
            dfs(grid, i, j-1);
        }
        //右
        if(j+1<col && grid[i][j+1] == '1') {
            dfs(grid, i, j+1);
        }
    }
}
