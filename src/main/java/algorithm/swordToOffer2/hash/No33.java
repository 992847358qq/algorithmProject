package algorithm.swordToOffer2.hash;

import java.util.*;

/**
 * @description: 变位词组
 * @author: gaoliang.wang
 * @date: 2022-02-26
 **/
public class No33 {
    //可以把字符串转换为hash值,自定义hash值
    public List<List<String>> groupAnagrams(String[] strs) {
        int hash[] =new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,
        43,47,53,59,61,67,71,73,79,83,89,97,101};
        Map<Long,List<String>> map = new HashMap<>();
        for (String str:strs){
            long workHash = 1;
            for (int i = 0; i < str.length(); i++) {
                workHash *= hash[str.charAt(i) - 'a'];
            }
            map.putIfAbsent(workHash,new LinkedList<String>());
            map.get(workHash).add(str);
        }
        return new LinkedList<>(map.values());
    }
}
