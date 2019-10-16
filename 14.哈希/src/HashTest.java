import java.util.Objects;

/**
 * 如果要用自定义的类型作为HashMap的key
 *                         HashSet的element
 *  保证：
 *  1.覆写hashCode()
 *  2.if key相同，那么对象不一定相同，但是对象相同，key一定相同
*/
class Persion{
    private int sn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persion persion = (Persion) o;
        return sn == persion.sn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn);
    }
}
public class HashTest{
    private static Node[] array = new Node[8];
    private static class Node{
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key){
        int index = key % array.length;
        Node head = array[index];
        Node cur;
        for(cur = head; cur != null;cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return -1;
    }

    //删除(本质查找)
    public int remove(int key){
        int index = key % array.length;
        Node head = array[index];
        if(head != null && head.key == key){
            array[index] = null;
            return head.key;
        }
        Node cur = null;
        Node pre = cur;
        for(cur = head; cur != null;cur = cur.next){
            if(cur.key == key){
                pre.next = cur.next;
                return cur.value;
            }
            pre = cur;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
