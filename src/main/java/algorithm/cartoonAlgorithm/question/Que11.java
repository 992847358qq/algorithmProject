package algorithm.cartoonAlgorithm.question;

/**
 * @author MR.Wang
 * @dept 寻找一个数组中，出现奇数次的两个整数
 * @description TODO
 * @date 2021/1/18 22:37
 **/
public class Que11 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,2,5,7,4,1};
        int[] result = new int[2];
        int oneResult = 0;
        for (int i = 0;i<arr.length;i++){
            oneResult^=arr[i];
        }
        //如果结果为0，说明数组里面不存在奇数次的两个整数
        if (oneResult == 0){
            System.out.println("数组不符合条件");
        }
        //确定两个整数的不同位，以此来分组
        int index = 1;
        while (0 == (oneResult&index)){
            index<<=1;
        }
        for (int k = 0;k<arr.length;k++){
            if ( 0 == (arr[k]&index)){
                result[0]^=arr[k];
            }else {
                result[1]^=arr[k];
            }
        }
        System.out.println(result[0]+":"+result[1]);
    }

}
