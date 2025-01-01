package algorithm.swordToOffer2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 合并区间
 * @author: gaoliang.wang
 * @date: 2022/3/12 1:23 PM
 **/
public class No74 {
    //整体时间复杂度为O(nlogn)
    public int[][] merge(int[][] intervals) {
        //排序时间复杂度为O(nlogn)
        Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        //数组长度为n，只会循环n次，时间复杂度为O(n)
        while (i<intervals.length){
            int[] temp = new int[]{intervals[i][0],intervals[i][1]};
            int j = i+1;
            while (j<intervals.length && intervals[j][0]<=temp[1]){
                temp[1] = Math.max(temp[1],intervals[j][1]);
                j++;
            }
            merged.add(temp);
            i=j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }
}
