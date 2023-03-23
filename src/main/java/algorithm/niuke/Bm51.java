package algorithm.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数组中出现次数超过一半的数字
 * @author: gaoliang.wang
 * @date: 2022/4/24 10:30 PM
 **/
public class Bm51 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        int half_length = array.length/2;
        for(Integer in:map.keySet()){
            if (map.get(in)>half_length){
                return in;
            }
        }
        return -1;
    }
}
