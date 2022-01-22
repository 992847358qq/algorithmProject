package algorithm.sort;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/10 23:18
 **/
public class HeapSort {
    public static void main(String[] args) {
        for (int i = 4; i >0 ; i--) {
            System.out.println(i);
            test(i);
        }
    }
    public static void test(int i){
        System.out.println(i+"--test");
    }
    public static void downAdjust(int[] arr,int parentIndex,int length){
        int temp = arr[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex<length){
            //如果有右孩子，且右孩子大于左孩子
            if (childIndex+1<length && arr[childIndex+1]>arr[childIndex]){
                childIndex++;
            }
            //如果父节点大于任何一个子节点，则直接跳出
            if (temp>=childIndex){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        arr[parentIndex] = temp;
    }
}
