package algorithm.swordToOffer2.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最近最少使用缓存
 * @author: gaoliang.wang
 * @date: 2022-02-25
 **/
public class No31 {

    class LruCache{
        public ListNode head;
        public ListNode tail;
        public Map<Integer,ListNode> map;
        public int capaticy;
        public LruCache(int cap){
            map  = new HashMap<>();
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next = tail;
            tail.prev = head;
            capaticy = cap;
        }
        public int get(int val){
            ListNode listNode = map.get(val);
            if (listNode == null){
                return -1;
            }
            moveTail(listNode,listNode.value);
            return listNode.value;
        }

        public void moveTail(ListNode listNode, int value) {
            deleteNode(listNode);
            listNode.value = value;
            insertTail(listNode);
        }

        public void put(int key,int value){
            if (map.containsKey(key)){
                moveTail(map.get(key),value);
            }else {
                if (map.size() == capaticy){
                    ListNode toBeDeleted = head.next;
                    deleteNode(toBeDeleted);
                    map.remove(toBeDeleted.key);
                }
                ListNode listNode = new ListNode(key,value);
                insertTail(listNode);
                map.put(key,listNode);
            }
        }

        private void deleteNode(ListNode toBeDeleted) {
            toBeDeleted.prev.next = toBeDeleted.next;
            toBeDeleted.next.prev = toBeDeleted.prev;
        }

        private void insertTail(ListNode listNode) {
            tail.prev.next = listNode;
            listNode.prev = tail.prev;
            listNode.next = tail;
            tail.prev = listNode;
        }

    }


}
