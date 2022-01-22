package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/23 23:35
 **/
public class Node {
    Integer data;
    Node next;
    public Node(Integer data){
        this.data = data;
    }
    public Node(Integer data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }
    public void setData(Integer data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
