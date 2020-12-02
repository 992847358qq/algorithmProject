package algorithm.practice1;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: wgl
 * @Date: 2020/07/27 18:03
 * @Description:
 */
public class TestEleven {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for(int i=0; i<5; i++) {
            a[i][i] = 1;
            a[i][0] = 1;
        }
        for(int i=2; i<5; i++) {
            for(int j=1; j<i; j++) {
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
        for(int i=0; i<5; i++) {
            for(int k=0; k<2*(5-i)-1; k++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
