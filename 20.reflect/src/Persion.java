public class Persion {
    public String name;
    private int age;
    public String sex;
    public String telephone;

    public Persion() {

    }

    public Persion(String name, int age, String sex, String telephone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("吃东西");
    }

    public void eat(String food){
    }
}
