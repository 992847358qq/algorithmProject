package tree;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author
 * @dept   优先队列
 * @description TODO
 * @date 2020/2/25 22:34
 **/
public class PriorityQueue {
    public static void main(String[] args) throws Exception {
            PriorityQueue priorityQueue = new PriorityQueue();
            priorityQueue.enQueue(3);
            priorityQueue.enQueue(5);
            priorityQueue.enQueue(10);
            priorityQueue.enQueue(2);
            priorityQueue.enQueue(7);
        System.out.println("出队元素："+priorityQueue.deQueue());
        System.out.println("出队元素："+priorityQueue.deQueue());
    }
    private int[] array;
    private int size;
    public PriorityQueue(){
        //队列初始长度为32
        array = new int[1];
    }
    /**
     * 上浮
     */
    private void upAdjust(){
        int childNode = size-1;
        int parentNode;
        if (childNode%2 == 0){
             parentNode = (childNode-2)/2;
        }else {
            parentNode = (childNode-1)/2;
        }
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childNode];
        while (childNode>0 && temp > array[parentNode]){
            //array[parentNode] = array[childNode];
            //parentNode = childNode;
            //单向赋值
            childNode = parentNode;
            array[childNode] = array[parentNode];
            parentNode = parentNode / 2;
        }
        array[childNode] = temp;
    }
    /**
     * 下浮调整
     */
    private void downAdjust(){
        //temp保存父节点的值，用于最后的赋值
        int parentNode = 0;
        int temp = array[parentNode];
        int childNode = 1;
        while (childNode < size){
            if (childNode+1 <size && array[childNode+1]>array[childNode]){
                childNode++;
            }
            if (temp>array[childNode]){
                break;
            }
            array[parentNode] = array[childNode];
            parentNode = childNode;
            childNode = childNode * 2 +1;
        }
        array[parentNode] = temp;
    }
    /**
     * 队列扩容
     */
    public void resize(){
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }
    /**
     * 入队
     */
    public void enQueue(int key){
        if (size>=array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }
    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if (size<0){
            throw new Exception("this queue is empty!");
        }
        //获取堆顶元素
        int head = array[0];
        //
        array[0] = array[size--];
        downAdjust();
        return head;
    }
}
