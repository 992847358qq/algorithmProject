package queue;

/**
 * @author MR.Wang
 * @dept 循环队列
 * @description TODO
 * @date 2020/6/14 11:19
 **/
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;
    public MyQueue(int capacity){
        this.array = new int[capacity];
    }
    /**
     * 入队元素
     */
    public void enQueue(int data) throws Exception {
        if ((rear+1)%array.length  == front){
            throw new Exception("队列已满！");
        }
        array[rear] = data;
        rear = (rear+1)%array.length;
    }

    /**
     * 出队元素
     */
    public int deQueue() throws Exception {
        if (rear == front){
            throw new Exception("队列已空!");
        }
        int element = array[front];
        front = (front+1)%array.length;
        return element;
    }
    /**
     * 输出队列
     */
    public void output(){
        for (int i=front;i!=rear;i=(i+1)%array.length){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.output();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }
}
