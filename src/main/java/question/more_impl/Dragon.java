package question.more_impl;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023/4/9 8:18 PM
 **/
public class Dragon extends Bird implements Fly,Sea {

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void featherColor(String color) {
        System.out.println("羽毛的颜色:"+color);
    }
}
