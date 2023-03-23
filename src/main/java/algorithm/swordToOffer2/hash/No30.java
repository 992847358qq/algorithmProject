package algorithm.swordToOffer2.hash;

import java.util.*;

/**
 * @description: 插入、删除和随机访问都是O(1)的容器
 * 插入、删除用哈希表来做，但哈希表会存在冲突，链表长度过长，时间复杂度就不是O(1)了
 * 采用数组插入、删除数据，哈希表key为数据，value为数组下标
 * 数组是连续空间，如果中间删除数据会存在位置移动，时间复杂度为O(n)
 * 所以数组删除时，删除数据位置与数字最后位置数据交换，达到删除目的。由于是尾部数据变更，不会涉及数据移动
 * @author: gaoliang.wang
 * @date: 2022-02-25
 **/
public class No30 {

    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> nums = new ArrayList<>();

    public boolean insert(Integer val){
        if (map.containsKey(val)){
            return false;
        }
        nums.add(val);
        map.put(val,nums.size()-1);
        return true;
    }

    public boolean remove(Integer val){
        if (!map.containsKey(val)){
            return false;
        }
        Integer location = map.get(val);
        map.put(nums.get(nums.size()-1),location);
        map.remove(val);
        nums.set(location, nums.get(nums.lastIndexOf(-1)));
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom(){
        Random random = new Random();
        int location = random.nextInt(nums.size());
        return nums.get(location);
    }
}
