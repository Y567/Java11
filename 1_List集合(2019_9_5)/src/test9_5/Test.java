package test9_5;

class Node{
    int val;
    Node next = null;
    public Node(int val){
        this.val = val;
    }
}

interface Air{
    //接口中可以实现静态方法（就是默认方法）
    default void fun(){
        System.out.println("fewf");
    }
}

class Arrayist extends Test{
    public Test fun(){
        System.out.println("子类");
        return new Test();
    }
}
public class Test {
    public Test fun(){
        System.out.println("weifbywfbiwjhfiw");
        return new Test();
    }
    //删除有序链表重复的结点(自己写的答案可能不对)
    public static Node remove(Node head,int val){
        Node p = head;
        Node pre = null;
        while(p != null){
            if(p.val != val){
                pre = p;
                p = p.next;
                continue;
            }else{
                if(pre == null){
                    pre = head.next;
                }else{
                    pre = p;
                    p.next = pre.next.next;
                }
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Test t = new Arrayist();//向上转型
        t.fun();            //编译器不认，编译期间编译器只认引用类型，只有执行期间才认对象
        Arrayist a = (Arrayist) t;
        a.fun();//强转（向下转型）
        System.out.println("成功了");
    }
}