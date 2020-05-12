package Java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author: wgl
 * @Date: 2019/11/21 16:50
 * @Description:
 */
public class StreamTest {
    public static void main(String[] args) {
        /*List<Integer> numbers = Arrays.asList(2,3,5,6,7,2,5,3);
        List<Integer> squarteList = numbers.stream().map(i-> i*i).distinct().collect(Collectors.toList());
        squarteList.forEach(System.out::println);*/
        /*Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);*/
        /*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count =  strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);*/
        /*List<Integer> numbers = Arrays.asList(2,3,5,6,7,2,5,3);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());*/
        /*String[] str = new String[]{"1.1","2.11","3.33"};
        List<String> strings = Arrays.asList(str);
        List<Double> list = strings.stream().map(i ->Double.parseDouble(i)).collect(Collectors.toList());
        System.out.println(list.toString());*/
        String str = "0";
        System.out.println(Integer.parseInt(str));
    }
}
