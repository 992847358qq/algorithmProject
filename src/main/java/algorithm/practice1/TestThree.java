package algorithm.practice1;

/**
 * @Author: wgl
 * @Date: 2020/07/21 11:39
 * @Description: 题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方
 */
public class TestThree {
    public static void main(String[] args) {
        for (int i = 101;i<1000;i++){
            int a,b,c;
            a = i%10;  //个位
            //b = i/10%10; //十位
            b =  i % 100 / 10; //十位
            c= i/100;//百位
            if((a*a*a + b*b*b + c*c*c) == i) {
                System.out.println(i+"是一个水仙花数"); }
        }
    }
    }
