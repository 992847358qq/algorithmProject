package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 斐波那契数列
 * @description TODO
 * @date 2021/1/29 22:34
 **/
public class No10 {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci1(10));
    }
    public static int fibonacci(int num){
        if (num <=0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        return fibonacci(num-1)+fibonacci(num-2);
    }

    public static int fibonacci1(int n){
        int fibone = 0;
        int fibtwo = 1;
        int finNum = 0;
        for (int i = 2;i<=n;i++){
            finNum = fibone+fibtwo;
            fibone = fibtwo;
            fibtwo = finNum;
        }
        return finNum;
    }
}
