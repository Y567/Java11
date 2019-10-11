import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Node {
    public int val;
    public Node next;
    public Node random;

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
            Node node = new Node();
            node.val = cur.val;

            node.next = cur.next;
            cur.next = node;

            cur = node.next;
        }
        //第二步复制random
        cur = head;
        while(cur != null){
            Node node = cur.next;
            if(cur.random != null){
                node.random = cur.random.next;
            }else{
                node.random = null;
            }
            cur = node.next;
        }

        //第三步拆新老链表，让老链表回归，新链表脱离
        cur = head;
        if(cur == null){
            return null;
        }
        Node newHead = cur.next;
        Node node = newHead;
        while(cur != null){
            if(node == null){
                break;
            }
            cur.next = node.next;
            cur = node.next;
            if(cur != null){
                node.next = cur.next;
            }
            node = node.next;
        }
        return newHead;
    }
    //可以利用Map的映射关系来进行深拷贝(不过需要加入比较器)
    public static Node copyRandomList2(Node head){
        Map<Node,Node> map = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        if(head == null){
            return null;
        }
        Node newHead = new Node();
        Node last = newHead;
        Node cur = head;
        while(cur != null){
            Node node = new Node();
            node.val = cur.val;
            last.next = node;
            map.put(cur,node);
            last = node;
            cur = cur.next;
        }
        cur = head;
        last = newHead.next;
        while(cur != null){
            //新旧链表长度一样，所以不需要考虑last为空因为last其实和cur一个性质
            Node node = last;
            if(cur.random != null){
                node.random = map.get(cur.random);
            }else{
                node.random = null;
            }
            last = last.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}
