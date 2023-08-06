package Java8.chat1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023-07-11
 **/
public class Apple {
    public String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:apples){
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreen(Apple apple){
        return "green".equals(apple.getColor());
    }

    interface  Predicate<T>{
        boolean test(T t);
    }

    public static List<Apple> filterGreenApples1(List<Apple> apples,Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:apples){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
