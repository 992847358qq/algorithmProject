package algorithm.cartoonAlgorithm.question;

import java.util.Arrays;
import java.util.List;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2021/1/16 22:28
 **/
public class Test {
    public static void main(String[] args) {
        String str = "123456779876";
        StringBuilder stringBuilder = new StringBuilder();
        int[] arr = new int[str.length()/5+1];
        int k = 0;
        int index = 1;
        for (int i = 0;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
            index++;
            if ( index %5 ==0){
                arr[k] = Integer.parseInt(stringBuilder.toString());
                k++;
                stringBuilder= new StringBuilder();
            }
            if (i == str.length()-1){
                if (stringBuilder.capacity() != 0){
                    arr[k] = Integer.parseInt(stringBuilder.toString());
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
