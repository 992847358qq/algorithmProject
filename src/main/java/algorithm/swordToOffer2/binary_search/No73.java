package algorithm.swordToOffer2.binary_search;

/**
 * @description: 狒狒吃香蕉
 * @author: gaoliang.wang
 * @date: 2022/3/10 10:09 PM
 **/
public class No73 {

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        System.out.println(new No73().minEatingSpeed(piles,h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i:piles){
            max = Math.max(max,i);
        }
        int left = 1;
        int right = max;
        while (left<=right){
            int mid = left + ((right-left) >> 1);
            int hour = getHours(piles,mid);
            if (hour<=h){
                if (mid == 1 || getHours(piles,mid-1)>h){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles, int speed) {
        int hour = 0;
        for(int i:piles){
            //如果当前数组数值小于speed，需要占1个小时。
            //speed -1 /speed = 0
            hour += (i + speed -1) / speed;
        }
        return hour;
    }
}
