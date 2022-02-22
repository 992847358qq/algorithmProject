package algorithm.swordToOffer2.binary_system;

/**
 * @description: 二进制加法
 * @author: gaoliang.wang
 * @date: 2022-02-08
 **/
public class No2 {
    public static void main(String[] args) {
        //01010101
        // 1001001
        //10011110
        System.out.println(addBinary("01010101","1001001"));
    }

    public static String addBinary(String a,String b){
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i>=0 || j>=0){
            int digitA = i>=0?a.charAt(i--) - '0':0;
            int digitB = j>=0?b.charAt(j--) - '0':0;
            int sum = digitA + digitB + carry;
            carry = sum>=2?1:0;
            sum = sum>=2?sum -2:sum;
            result.append(sum);
        }
        if (carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
