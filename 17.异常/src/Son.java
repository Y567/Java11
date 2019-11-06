public class Son extends Father {
    @Override
    public void test(){
        //没报错
        /*
         * 父类抛异常，子类可以不抛异常，或者抛同样的，或者抛的是父类抛的异常的子类
         */
    }
}
