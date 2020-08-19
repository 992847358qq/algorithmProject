package algorithm.practice1;

import java.util.Scanner;

/**
 * @Author: wgl
 * @Date: 2020/07/27 16:58
 * @Description:
 */
public class TestTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个大于1的奇数");
        int hight = scanner.nextInt();
        int mid = (hight+1)/2;
        int index = mid;
        for (int i=1;i<=hight;i++){
            for (int j =1;j<=Math.abs(i-mid);j++){
                System.out.print(" ");
            }
            if (i<=4){
                for (int k=1;k<=2*i-1;k++){
                    System.out.print("*");
                }
            }else {
                index = index-1;
                for (int d = 1;d<=2*index-1;d++){
                    System.out.print("*");
                }
            }
            for (int j =1;j<=Math.abs(i-mid);j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
