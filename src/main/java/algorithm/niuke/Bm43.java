package algorithm.niuke;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/4/23 10:15 PM
 **/
public class Bm43 {
    List<Integer> list = new LinkedList<>();
    public int min = Integer.MAX_VALUE;
    public void push(int node) {
        list.add(node);
        min = Math.min(node,min);
    }

    public void pop() {
        if (!list.isEmpty()){
            int node = list.remove(list.size()-1);
            if (node == min){
                min = Integer.MAX_VALUE;
                if (!list.isEmpty()){
                    for (int i = 0; i < list.size(); i++) {
                        min = Math.min(min,list.get(i));
                    }
                }
            }
        }
    }

    public int top() {
        if (!list.isEmpty()){
            return list.get(list.size()-1);
        }
        return -1;
    }

    public int min() {
        return min;
    }
}
