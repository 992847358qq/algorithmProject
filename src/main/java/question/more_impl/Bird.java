package question.more_impl;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2023/4/9 1:13 PM
 **/
public  abstract class Bird implements Fly {

    public void isBird(){
        System.out.println("鸟类");
    }

    public abstract void featherColor(String color);
}
