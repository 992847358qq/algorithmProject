package practice;

/**
 * @author MR.Wang
 * @dept
 * @description TODO
 * @date 2020/6/22 23:25
 **/
public class TransForValue {
    public void changeValue(int age){
        age = 30;
    }
    public void changeName(Person person){
        person.setName("wgl");
    }
    public void changeStr(String str){
        str = "xxx";
    }
    public static void main(String[] args) {
        int age = 20;
        TransForValue transForValue = new TransForValue();
        transForValue.changeValue(age);
        System.out.println(age);

        Person person = new Person(18,"abc");
        transForValue.changeName(person);
        System.out.println(person.getName());

        String str = "wxs";
        transForValue.changeStr(str);
        System.out.println(str);
    }
}
