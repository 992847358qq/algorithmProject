package algorithm.swordToOffer2.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 日程表
 * @author: gaoliang.wang
 * @date: 2022/3/2 10:59 PM
 **/
public class No58 {
    private TreeMap<Integer,Integer> events;
    public No58(){
        events = new TreeMap<>();
    }
    //时间复杂度O（logn），空间复杂度O(n)
    public boolean book(int start,int end){
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start){
            return false;
        }
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end){
            return false;
        }
        events.put(start,end);
        return true;
    }
}
