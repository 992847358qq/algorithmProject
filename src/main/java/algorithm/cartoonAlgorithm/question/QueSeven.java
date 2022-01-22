package algorithm.cartoonAlgorithm.question;

import java.util.Arrays;

/**
 * @author MR.Wang
 * @dept 寻找全排列的下一个数
 * @description TODO
 * @date 2021/1/15 22:43
 **/
public class QueSeven {
    public static void main(String[] args) {

    }
    public static int[] findNearestNumber(int[] numbers){
        //从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字边界为0，说明数组已是逆序，无法获得更大的相同数字组成的整数，返回Null
        if (index == 0){
            return null;
        }
        int[] numCopy = Arrays.copyOf(numbers,numbers.length);
        //逆序区域前一位与逆序区域中刚刚大于它的数字进行交换
        exchangeHead(numCopy,index);
        //把原来的逆序区域转为顺序；
        reverse(numCopy,index);
        return numCopy;
    }

    private static int[] reverse(int[] numCopy, int index) {
        for (int i = index,j=numCopy.length-1;i<j;i++,j--){
            int temp = numCopy[i];
            numCopy[i] = numCopy[j];
            numCopy[j] = temp;
        }
        return numCopy;
    }

    //逆序区域
    private static int[] exchangeHead(int[] numCopy, int index) {
        int head = numCopy[index-1];
        for (int i = numCopy.length-1; i >0 ; i--) {
            if (head<numCopy[i]){
                numCopy[index-1] = numCopy[i];
                numCopy[i] = head;
                break;
            }
        }
        return numCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length-1;i>0;i--){
            if (numbers[i]>numbers[i-1]){
                return i;
            }
        }
        return 0;
    }
}
