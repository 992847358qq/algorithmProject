package algorithm.niuke;

/**
 * @description: 数组中只出现一次的两个数字
 * @author: gaoliang.wang
 * @date: 2022/4/24 10:49 PM
 **/
public class Bm52 {
    //哈希表做统计可以算出来
    //也可以通过异或，相同的两个数字异或等于0。数组循环异或，最后得到的异或和，是两个出现一次数字的异或结果
    //需要从这个异或和里面拆分出来两个数字，可以找出二进制中第一个不相同的位置,也就是等于1的位置
    //然后根据1的位置对数组进行拆分
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp^=array[i];
        }
        //找出二进制中第一个不相同的位置
        int k = 1;
        while ((k&temp) == 0){
            k<<=1;
        }
        int res1 = 0;
        int res2 = 0;
        //根据这个位置对数组进行拆分，单独做异或运算
        //相同的两个数异或等于0，不同的两个数根据第一个不相同的位置，一定可以取出来
        for (int i = 0; i < array.length; i++) {
            if ((k & array[i]) == 0){
                res1 ^=array[i];
            }else {
                res2 ^=array[i];
            }
        }
        if (res1>res2){
            return new int[]{res2,res1};
        }
        return new int[]{res1,res2};
    }
}
