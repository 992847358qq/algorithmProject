package algorithm.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: gaoliang.wang
 * @date: 2022/4/24 10:07 PM
 **/
public class Bm50 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        if (numbers == null){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])){
                if (i>map.get(target-numbers[i])){
                    return new int[]{map.get(target-numbers[i])+1,i+1};
                }
                return new int[]{i+1,map.get(target-numbers[i])+1};
            }else {
                map.put(numbers[i],i);
            }
        }
        return new int[]{};
    }
}
