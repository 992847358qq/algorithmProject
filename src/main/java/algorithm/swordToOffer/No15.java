package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 二进制中1的个数
 * @description TODO
 * @date 2021/2/1 21:20
 **/
public class No15 {
    public static void main(String[] args) {
        System.out.println(getOneNum(7));
        System.out.println(getOneNum1(7));
        System.out.println(getOneNum2(7));
    }
    public static int getOneNum(int num){
        int count = 0;
        while (num!=0){
            if ((num&1) == 1){
                count++;
            }
            num = num>>1;
        }
        return count;
    }

    public static int getOneNum1(int num){
        int count = 0;
        int flag = 1;
        while (flag<= num){
            if ((num&flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }
    //每次减1，与原数与运算，就会抵消一个1
    public static int getOneNum2(int num){
        int count = 0;
        while (num != 0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
}
