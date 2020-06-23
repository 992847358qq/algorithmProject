package First;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wgl
 * @Date: 2020/05/14 13:47
 * @Description:
 */
public class Atest {
    public static void main(String[] args) {
        /*String str = "[ zhǐ hǎo ]";
        if (str.length()>1){
            String string = str.substring(1,str.length()-1);
            String[] s = string.split(" ");
            for (String s1 : s) {
                System.out.println(s1);
            }
        }*/
        for (int i = 0;i<10;i+=2){
            System.out.println(i);
        }
        ThreadLocal threadLocal = new ThreadLocal();
        List<String> list = new ArrayList<>();
    }
}
