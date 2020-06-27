package linkedList;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/5/23 23:25
 **/
public class InsertNode {
    private static class Node{
        int data;
        Node next;
        public Node(int val){
            this.data = val;
        }
    }
    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;
    /**
     * 链表插入元素
     */
    public void insert(int data,int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
    }
}

