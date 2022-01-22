package algorithm.swordToOffer;

import java.util.Stack;

/**
 * @author MR.Wang
 * @dept 倒序打印链表
 * @description TODO
 * @date 2021/1/23 23:35
 **/
public class No6 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        //reverse1(node1);
        //reverse2(node1);
        Node node = reverse3(node1);
        while (node!= null){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    //递归实现
    private static void reverse1(Node node1) {
        if (node1 != null){
            if (node1.getNext() != null){
                reverse1(node1.getNext());
            }
        }
        System.out.println(node1.getData());
    }
    //用栈实现
    private static void reverse2(Node head){
        Stack<Node> stack = new Stack<>();
        while (head!= null){
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }
    //逆序链表顺序
    private static Node reverse3(Node head){
        Node pre = head;
        Node cur = pre.getNext();
        Node temp;
        while (cur!= null){
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }
}
