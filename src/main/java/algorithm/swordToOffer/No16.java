package algorithm.swordToOffer;


/**
 * @author MR.Wang
 * @dept 求数值的整数次方  （次方可能为负数）
 * @description TODO
 * @date 2021/2/1 22:53
 **/
public class No16 {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }
    //2的8次方 = 2的4次方的平方
    //2的7次方 = 2的三次方的平方 再乘以2
    static double power(double num,int pw){
        if (pw == 0){
            return 1;
        }
        if (pw == 1){
            return num;
        }
        double result = power(num, pw>>1);
        result *= result;
        //判断是否为奇数
        if ((pw&1) == 1){
            result*=num;
        }
        return result;
    }
}
