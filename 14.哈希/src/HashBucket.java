/**
 * 哈希桶
 * key-value型
 * 负载因子高了就加长数组长度来降低负载因子
 */
public class HashBucket {
    private static class Node{
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array;
    private int size; //当前数据个数
    private static final double LOAD_FACTOR = 1.75;
    private double loadFactor(){
        return size*1.0/array.length;
    }

    public void resize(){
/*
       Node[] temp = array;
        array = new Node[array.length*2];
        array = Arrays.copyOfRange(temp,0,temp.length-1);*/
        Node[] newArray = new Node[array.length*2];
        for(int i = 0; i < array.length;i++){
            Node next;
            for(Node cur = array[i];cur != null;cur = next){
                next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }
    public HashBucket(){
        array = new Node[8];
        size = 0;
    }
    public int get(int key){
        //1.key-->int
        //2.下标合法
        int index = key % array.length;

        Node head = array[index];
        for(Node cur = head; cur != null;cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return -1;
    }

    //插入
    public int put(int key,int value){
        int index = key % array.length;
        for(Node cur = array[index];cur != null;cur = cur.next){
            if(key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        //说明没找到重复的key，所以需要加入这个节点
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        size++;
        if(loadFactor() >= LOAD_FACTOR){
            resize();
        }
        return -1;
    }
}
