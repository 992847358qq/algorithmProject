package algorithm.swordToOffer2.binary_system;

/**
 * @description: 整数除法，需要判断溢出情况
 * @author: gaoliang.wang
 * @date: 2022-02-08
 **/
public class No1 {
    //0x80000000为最小的int型整数-2的31次方；0xc0000000是它的一半为-2的30次方
    //
    public static void main(String[] args) {
        System.out.println(divide(125,6));
    }

    public static int divide(int dividend,int divisor){
        if (dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int flag = 2;
        if (dividend>0){
            flag-=1;
            dividend = -dividend;
        }

        if (divisor>0){
            flag-=1;
            divisor = -divisor;
        }
        int result = divideCode(dividend, divisor);
        return flag == 1?-result:result;

    }

    public static int divideCode(int dividend,int divisor){
        int result = 0;
        while (dividend <= divisor){
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value+value){
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
