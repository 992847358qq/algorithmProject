package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.nio.cs.ext.IBM037;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author MR.Wang
 * @dept    找出偶数id且年龄大于22且用户名转为大写且用户名字母倒序排序
 *          只输出一个用户名字
 * @description TODO
 * @date 2020/6/29 22:13
 **/
public class StreamDemo {
    public static void main(String[] args) {
        User user = new User(11,"a",23);
        User user1 = new User(12,"b",25);
        User user2 = new User(16,"g",28);
        User user3 = new User(18,"t",22);
        User user4 = new User(20,"i",29);
        List<User> list = Arrays.asList(user,user1,user2,user3,user4);
        list.stream().filter(s -> {
            return  s.getId() % 2 == 0 ;
        }).filter(u->{return u.getAge()>22 ;
        }).map(s->{return s.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {return -o1.compareTo(o2);}).limit(1).forEach(System.out::println);

        /*List<Integer> list = Arrays.asList(1,2,3);
        list.stream().map(s->{return s*2;}).collect(Collectors.toList()).forEach(System.out::println);*/















        //函数式接口
        /*Function<String, Integer> function = s -> {return s.length();};
        System.out.println(function.apply("wgl"));*/
        //断定型接口
        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.equals("wgl"))
                return true;
                else
                    return false;
            }
        };
        System.out.println(predicate.test("wgl"));*/
        /*Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("asd"));*/

        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };*/
        //消费型接口
        /*Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("wgl");*/
        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };*/
        /*Supplier<String> supplier = ()->{return "wgl";};
        System.out.println(supplier.get());*/
    }
}
@Data
@AllArgsConstructor
class User{
    private int id;
    private String userName;
    private int age;
}
