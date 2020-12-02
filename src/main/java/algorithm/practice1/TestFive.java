package algorithm.practice1;

import java.util.Scanner;

/**
 * @Author: wgl
 * @Date: 2020/07/21 15:42
 * @Description: 利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示
 */
public class TestFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        char x;
        x=data>=90?'A':data>=60?'B':'C';
        System.out.println(x);
    }
}
