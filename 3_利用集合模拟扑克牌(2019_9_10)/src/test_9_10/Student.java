package test_9_10;

public class Student {
    String sn;//学号
    String name;
    int age;
    int gender;//性别
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Student)){
            return false;
        }
        Student o = (Student)obj;
        if(o.age == this.age && o.gender == this.gender && o.name.equals(this.name) && o.sn.equals(this.sn)){
            return true;
        }
        return false;
    }
}
