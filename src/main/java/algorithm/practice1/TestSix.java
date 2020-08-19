package algorithm.practice1;

import java.util.Scanner;

/**
 * @Author: wgl
 * @Date: 2020/07/21 17:04
 * @Description: 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * /**在循环中，只要除数不等于0，用较大数除以较小的数，将小的一个数作为下一轮循环的大数，
 * 取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回较大的数，此数即为最大公约数，最小公倍数为两数之积除以最大公约数
 */
public class TestSix {
    public static void main(String[] args) {
        int a,b,d;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println("键入一个整数："+a);
        b = scanner.nextInt();
        System.out.println("键入一个整数："+b);
        d = new TestSix().deff(a,b);
        System.out.println("最大公约数："+d);
        System.out.println("最小公倍数："+a*b/d);
    }

    public int deff(int x,int y){
        if (x<y){
            int temp = y;
            y = x;
            x = temp;
        }
        while (y!=0){
            if (x == y){
                return x;
            }
            int k = x%y;
            x = y;
            y = k;
        }
        return x;
    }
}
