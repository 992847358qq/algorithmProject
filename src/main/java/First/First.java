package First;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wgl
 * @Date: 2019/9/27 15:36
 * @Description:
 */
public class First {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("是");
        }
        System.out.println(list.size());
    }
}
