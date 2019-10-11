class Node {
    private int val;
    private Node next;
    private Node random;

    public Node() {}

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
//深拷贝链表
public class CopyRandomList {
    public static Node copyRandomList(Node head){
        //第一步变为新老链表连接，旧链表断开
        Node cur = head;
        while(cur != null){

        }


        //第二步复制random


        //第三步拆新老链表，让老链表回归，新链表脱离
        return new Node();
    }



    //可以利用Map的映射关系来进行深拷贝
}
