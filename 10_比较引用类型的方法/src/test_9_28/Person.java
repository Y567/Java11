package test_9_28;

import java.util.Comparator;

/**
 * String 和Integer Java已经实现
 *1.自然顺序  类实现Comparable接口(自带一个比较方法---只需要两者比较不需要引入第三者)
 *   直接p.compareTo(q)
 * 2.非自然顺序（引入一个比较器（裁判）--不自然了）  定义一个比较器（实现Comparator）类
 *   Comparator 比较器 = new ...;
 * 3.为什么引入Comparator？
 * 有些类本身不带比较功能，我们又不好改变其类的结构，所以此时就需要引入比较器
 */


class PersonNameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}

//基于身高的比较
class PersonHeightComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.height - o2.height;
    }
}

//比较器（身高>>体重（轻）>>姓名>>年龄）
class PersonCompare implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.height - o2.height == 0){
            if(o1.weight - o2.weight == 0){
                if(o1.name.compareTo(o2.name) == 0){
                    return o1.age - o2.age;
                }
                else{
                    return o1.name.compareTo(o2.name);
                }
            }else{
                return o1.weight - o2.weight;
            }
        }
        else{
            return o1.height - o2.height;
        }
    }
}
public class Person implements Comparable<Person>{
    public String name;
    public int age;
    public int height;
    public int weight;
    public int level;
    public int gender;


    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        //简便写法
        return this.height - o.height;
//        if(this.age < o.age){
//            return -1;
//        }else if(this.age == o.age){
//            return 0;
//        }else{
//            return 1;
//        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("p1",19);
        Person p2 = new Person("p2",18);
        //比较器（名字）
        Comparator<Person> c = new PersonNameComparator();
        //比较器（身高）
        Comparator<Person> c2 = new PersonHeightComparator();
        //实现比较器，也可以比较
        System.out.println("======按名字比较======");
        int s = c.compare(p1,p2);
        System.out.println(s);
        System.out.println("======按身高比较======");
        p1.height = 170;
        p2.height = 187;
        int r = c2.compare(p1,p2);
        if(r < 0){
            System.out.println(p1.name+"小");
        }else if(r == 0){
            System.out.println("一样大");
        }else{
            System.out.println(p2.name+"小");
        }
    }
}
