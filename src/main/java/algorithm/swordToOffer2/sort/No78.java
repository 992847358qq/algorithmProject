package algorithm.swordToOffer2.sort;

import algorithm.swordToOffer2.linkedList.ListNode;

import java.util.PriorityQueue;

/**
 * @description: 合并排序链表
 * 可以用归并排序，也可以用借助于最小堆
 * @author: gaoliang.wang
 * @date: 2022/3/13 10:18 PM
 **/
public class No78 {
    //k个排序链表总共有n个节点，借助于最小堆，空间复杂度为O(n)
    //每次最小堆排序时间复杂度为(logk)，总共时间复杂度为O(nlogk)
    public ListNode mergeKLists(ListNode[] lists){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((m1,m2)->m1.val - m2.val);
        for (ListNode node:lists){
            if (node!=null){
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()){
            ListNode poll = minHeap.poll();
            cur.next = poll;
            cur = poll;
            if (cur.next!= null){
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
