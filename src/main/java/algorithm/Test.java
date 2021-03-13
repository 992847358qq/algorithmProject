package algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/5 21:41
 **/
public class Test {
    public static void main(String[] args) {
        /*BigDecimal data1 = new BigDecimal("1.63");
        BigDecimal data2 = new BigDecimal("1.0");
        if (data1.compareTo(data2) < 0) {
            System.out.println("第二位数大！");
        }
        if (data1.compareTo(data2) == 0) {
            System.out.println("两位数一样大！");
        }
        if (data1.compareTo(data2) > 0) {
            System.out.println("第一位数大！");
        }*/
        /*String str = "str";
        System.out.println(str.charAt(0));*/
        //System.out.println(get().toString());
        System.out.println(get1());
    }
    public static List get(){
        List<Integer> list = new ArrayList<>();
        try{
            return list;
        } catch(Exception e){
            list.add(1);
            return list;
        }finally{
            list.add(2);
        }
    }
    public static int get1(){
        int i = 0;
        try{
            i++;
            int j= i/0;
            return i;
        } catch(Exception e){
            i++;
            return i;
        }finally{
            i++;
            return i;
        }
    }
}
