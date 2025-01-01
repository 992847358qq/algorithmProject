package algorithm;


import algorithm.swordToOffer2.linkedList.ListNode;

import java.util.*;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/5 21:41
 **/
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0,1,2,1,1,1,0,0,1,1,1,0,1};
        System.out.println(getSeat(arr));
    }

    public static ListNode getNode(ListNode head){
        ListNode node = head;
        ListNode tail = null;
        while (node != null){
            ListNode next = node.next;
            if (node.child != null){
                ListNode childNode = node.child;
                ListNode tailNode = getNode(childNode);
                node.child = null;
                node.next = childNode;
                childNode.prev = node;
                if (next != null){
                    tailNode.next = next;
                    next.prev = tailNode;
                }
                tail =  tailNode;
            }else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }

    //1110121110011101
    public static int getSeat(int[] arr){
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int cur = -1;
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 1){
               sum += 1;
           }else if(arr[i] == 0){
               if (cur == -1){
                   cur = i;
               }
               int a = map.getOrDefault(cur,0)+sum;
               if (a>max){
                   max = a;
                   result = cur;
               }
               map.put(cur,a);
               cur = i;
               map.put(cur,map.getOrDefault(cur,0)+sum);
               a = map.getOrDefault(cur,0)+sum;
               if (a>max){
                   max = a;
                   result = cur;
               }
               sum = 0;
           }else if(arr[i] == 2){
               int b = map.getOrDefault(cur,0)+sum;
               if (b>max){
                   max = b;
                   result = cur;
               }
               map.put(cur,map.getOrDefault(cur,0)+sum);
               sum = 0;
               cur = -1;
           }
        }
        return result;
    }
}
