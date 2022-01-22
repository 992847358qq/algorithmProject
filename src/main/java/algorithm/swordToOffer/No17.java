package algorithm.swordToOffer;

/**
 * @author MR.Wang
 * @dept 打印从1到最大的n位数
 * 输入数字n，按顺序打印从1到n位数字最大值，比如输入3，则打印1、2-999
 * @description TODO
 * @date 2021/2/1 23:15
 **/
public class No17 {
    public static void main(String[] args) {
        printNum(3);
    }

    private static void printNum(int n) {
        if (n < 0) return;
        int[] array = new int[n];
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {
        if (n != array.length) {
            for (int i = 0; i < 10; i++) {
                array[n] = i;
                printArray(array, n + 1);
            }
        } else {
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    flag = true;
                }
                if (flag) {
                    System.out.print(array[j]);
                }
            }
            if (flag)
                //去掉空白行
                System.out.println();
        }
    }
}
