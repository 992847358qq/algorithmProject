package algorithm.practice1;

/**
 * @Author: wgl
 * @Date: 2020/07/23 13:57
 * @Description: 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 */
public class TestNine {
    public static void main(String[] args) {
        for (int i = 1;i<=10000;i++){
            if (Math.sqrt(i+100) % 1 == 0){
                if (Math.sqrt(i+168) % 1 == 0){
                    System.out.println(i + "加100是一个完全平方数，再加168又是一个完全平方数");
                }
            }
        }
    }
}
