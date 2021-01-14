package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wgl
 * @Date: 2020/08/28 14:17
 * @Description:
 */
public class PracticeOne {
    public static void main(String[] args) {
        //test2();
        //streamTest2();
        //flatMapStream();
        //randomTest();
        //skipTest();
        //peekTest();
        //parallelTest();
        matchTest();
    }

    public static void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.forEach((k,v)->{
            System.out.println("k:"+k+","+"v:"+v);
        });
    }

    public static void test2(){
        /*List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.forEach(v->{
            System.out.println(v);
        });
        list.forEach(System.out::println);*/
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(list.stream().mapToInt(l -> l).sum());

    }

    public static void streamTest(){
        List<String> list = Arrays.asList("张三","李四","王五","赵六");
        System.out.println(list.toString());
        System.out.println("过滤后");
        List<String> result = list.stream().filter(str->!"李四".equals(str)).collect(Collectors.toList());
        System.out.println(result.toString());
    }

    public static void streamTest1(){
        /*Stream<String> stream = Stream.of("a","b","c");
        String[] strArray = stream.toArray(String[]::new);*/
        /*List<String> list = Arrays.asList("wangsan","wangyihan");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);*/
        List<String> list = Arrays.asList("1","2","3");
        List<Integer> collect = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void streamTest2(){
        List<String> list = Arrays.asList("张三","李四","王五");
        String result = list.stream().filter(str->"张三".equals(str)).findAny().orElse("找不到");
        String result1 = list.stream().filter(str->"张五".equals(str)).findAny().orElse("找不到");
        System.out.println("stream过滤之后："+result);
        System.out.println("stream过滤之后："+result1);
    }

    public static void flatMapStream(){
        String worlds = "the way of the future";

        System.out.println("lamada表达式：");
        List<String> list1 = Arrays.asList(worlds);
        List<String> collect = list1.stream().flatMap(str -> Stream.of(str.split(" "))).filter(world -> world.length() > 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("普通表达式：");
        String[] s = worlds.split(" ");
        Arrays.stream(s).forEach(System.out::println);
    }

    public static void randomTest(){
        Random random = new Random();
        random.ints().limit(3).forEach(System.out::println);
    }

    //skip跳过前几个元素
    public static void skipTest(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd");
        list.stream().limit(3).skip(2).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void peekTest(){
        System.out.println("peek使用:");
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3).peek(e -> System.out.println("转换之前: " + e))
                .map(String::toUpperCase).peek(e -> System.out.println("转换之后: " + e)).collect(Collectors.toList());
    }

    public static void parallelTest(){
        List<String> strings = Arrays.asList("a", "", "c", "", "e","", " ");
        // 获取空字符串的数量
        long count =  strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的个数:"+count);
    }

    public static void matchTest(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        boolean all = list.stream().allMatch(u -> u > 3);
        System.out.println("是否都大于3:" + all);
        boolean any = list.stream().anyMatch(u -> u > 3);
        System.out.println("是否有一个大于3:" + any);
        boolean none = list.stream().noneMatch(u -> u > 3);
        System.out.println("是否没有一个大于3的:" + none);
    }
}


