package leetcode;

/**
 * @description: 种花问题，花不能种植在相邻的地块上
 * 区间问题
 * @author: gaoliang.wang
 * @date: 2022/10/24 11:13 PM
 **/
public class leet605 {
    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0,len = flowerbed.length;i<len && n>0;){
            //当i=1是，那么i+1一定是0，此时直接从i+2开始
            if (flowerbed[i] == 1){
                i+=2;
                //当遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，
                // 此时只需要判断下一格是不是1即可得出index这一格能不能种花，
                // 如果能种则令n减一，然后这个位置就按照遇到1时处理，即跳两格；
                // 如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花，直接跳过3格。
            }else if (i == len-1 || flowerbed[i+1] == 0){
                n--;
                i+=2;
            }else {
                i+=3;
            }
        }
        return n<=0;
    }
}
