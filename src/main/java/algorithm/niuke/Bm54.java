package algorithm.niuke;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 三数之和
 * @author: gaoliang.wang
 * @date: 2022/4/25 11:14 PM
 **/
public class Bm54 {
    //-40,-10,-10,0,10,20

    public static void main(String[] args) {
        int [] num = new int[]{0,0,0};
        System.out.println(new Bm54().threeSum(num));
    }
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length == 0 || num.length<3){
            return  new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        int left = 0;
        int right = num.length-1;
        while (left!=right){
            if (num[left]+num[right]+num[right-1] == 0){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num[left]);
                list.add(num[right]);
                list.add(num[right-1]);
                result.add(list);
                while (num[left] == num[left+1]){
                    left++;
                }
                while (num[right-1] == num[right-2]){
                    right--;
                }
            } else if (num[left]+num[left+1]+num[right] == 0){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num[left]);
                list.add(num[left+1]);
                list.add(num[right]);
                result.add(list);
                while (num[left] == num[left+1]){
                    left++;
                }
                while (num[right-1] == num[right-2]){
                    right--;
                }
            }
            if (num[left]+num[right]+num[right-1] <0){
                    left++;
            }else {
                    right--;
            }
        }
        return result;
    }
}
