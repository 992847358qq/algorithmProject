package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept 求两个数的最大公约数
 * @description TODO
 * @date 2021/1/13 22:10
 **/
public class QueThree {
    public static int main(int a,int b){
        if (a == b){
            return a;
        }
        if ((a&1) == 0 && (b&1) == 0){
            return main(a>>1,b>>1)<<1;
        }else if ((a&1) == 0 && (b&1)!= 0){
            return main(a>>1,b);
        }else if((a&1)!=0 && (b&1) == 0){
            return main(a,b>>1);
        }else {
            int big = a>b?a:b;
            int small = a<b?a:b;
            return main(big-small,small);
        }
    }

    public static void main(String[] args) {
        System.out.println(main(5,10));
        System.out.println(main(15,40));
        System.out.println(main(100,80));
    }
}
