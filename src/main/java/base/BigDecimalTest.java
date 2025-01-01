package base;

import java.math.BigDecimal;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023-08-14
 **/
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(1.0);
        BigDecimal bigDecimal2 = new BigDecimal(1.00);
        System.out.println(bigDecimal1.equals(bigDecimal2));
    }
}
