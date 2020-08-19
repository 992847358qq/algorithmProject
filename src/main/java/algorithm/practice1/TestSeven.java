package algorithm.practice1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wgl
 * @Date: 2020/07/21 17:59
 * @Description: 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
 */
public class TestSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int acCount = 0;//英文字符数
        int spaceCount = 0 ;//空格数
        int numCount = 0; //数字数量
        int otherCount = 0; //其它字符数量
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])){
                //判断是否是字母
                acCount++;
            }else if (Character.isDigit(chars[i])){
                //判断是否是数字
                    numCount++;
            }else if (Character.isSpaceChar(chars[i])){
                //判断是否是空格
                spaceCount++;
            }else {
                //其它字符
                otherCount++;
            }
        }
        System.out.println("英文字母数："+acCount);
        System.out.println("空格数："+spaceCount);
        System.out.println("数字数："+numCount);
        System.out.println("其它字符数："+otherCount);
    }
}
