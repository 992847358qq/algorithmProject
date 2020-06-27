package practice;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/22 23:29
 **/
public class Person {
    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
