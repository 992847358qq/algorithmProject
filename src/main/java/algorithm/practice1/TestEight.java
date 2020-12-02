package algorithm.practice1;

import java.util.Scanner;

/**
 * @Author: wgl
 * @Date: 2020/07/23 13:45
 * @Description:  题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制
 */
public class TestEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数字
        int a = scanner.nextInt();
        System.out.println("输入数字："+a);
        //位数
        int b = scanner.nextInt();
        System.out.println("输入相加的项数："+b);
        int count = 0;
        int sum = 0;
        while (b>0){
            count = count*10+a;
            sum+=count;
            b--;
        }
        System.out.println("和为："+sum);
    }
}
