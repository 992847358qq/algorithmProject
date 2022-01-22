package algorithm.practice1;

/**
 * @Author: wgl
 * @Date: 2020/07/21 10:09
 * @Description: 菲波拉契数列 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class TestOne {
    public static void main(String[] args) {
        System.out.println("第1个月的兔子对数: 1");
        System.out.println("第2个月的兔子对数: 1");
        int a = 1,b=1,count = 0;
        int mon = 24;
        for (int i = 3;i<=24;i++){
            count = a + b;
            a = b;
            b = count;
            System.out.println("第"+i+"个月的兔子对数: "+count);
        }
    }
}