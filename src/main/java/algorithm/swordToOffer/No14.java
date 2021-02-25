package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 剪绳子，动态规划问题,一个绳子长度为n，剪成m段(n>1,m>1)，求长度的最大乘积
 * 绳子为1米，最大1；绳子为2米，最大1；绳子为3米，最大1*2为2
 * f(n)=max(f(i)*f(n-i))
 * @description TODO
 * @date 2021/1/31 23:21
 **/
public class No14 {
    public static void main(String[] args) {
        System.out.println(getMax(5));
        System.out.println(greedy(5));
    }
    //动态规划，求最优解，自下而上的求
    public static int getMax(int length){
        if (length<2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        int[] ropes = new int[length+1];
        ropes[0] = 0;
        ropes[1] = 1;
        ropes[2] = 2;
        ropes[3] = 3;
        int max = 0 ;
        for (int i = 4; i <=length ; i++) {
            max = 0;
            for (int j = 1; j <= length/2; j++) {
               int rope = ropes[j]*ropes[i-j];
               if (max<rope){
                   max = rope;
               }
               ropes[i] = max;
            }
        }
        return max;
    }
    //贪婪算法，每一步都是贪婪选择，

    public static int greedy(int length){
        if (length<2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        //尽可能的减去长度为3的绳子
        int timesOf3 = length/3;
        //当绳子长度最后为4时，不能减去3；因为2*2>3*1
        if (length-timesOf3*3 == 1){
            timesOf3-=1;
        }
        int timeOf2 = (length - timesOf3*3)/2;
        return (int)Math.pow(3,timesOf3) * (int)Math.pow(2,timeOf2);
    }
}
