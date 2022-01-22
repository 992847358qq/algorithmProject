package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept 求一个整数是否是2的整数幂
 * @description TODO
 * @date 2021/1/13 22:42
 **/
public class QueFour {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(10));
        System.out.println(isPowerOf2(16));
    }
    public static boolean isPowerOf2(int a){
        return (a&(a-1)) == 0;
    }
}
