package test_10_8;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
    }

}

/**
 * 二叉排序树（二叉树形式的搜索树）
 * 纯key模型
 */
public class BinarySearchTree {
    private static Node root;
    //插入，插入成功返回true
    private boolean insert(int key){
        Node cur = root;
        if(cur == null){
            root = new Node(key);
            return true;
        }
        Node parent = null;
        while(cur != null){
            if (cur.key == key){
                return false;
            }else if(cur.key > key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key);
        if(key < parent.key){
            parent.left = node;
        }else if(key > parent.key){
            parent.right = node;
        }else{
            return false;
        }
        return true;
    }

    //搜索
    private Node search(int key){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur;
            }else if(cur.key < key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return null;
    }


    //中序遍历
    private void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

    /**
     * 删除成功返回true，失败返回false
     */
    private boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(cur.key == key){
                //找到编写删除方法
                removeNode(parent,cur);
                return true;
            }else if(cur.key < key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node goatParent = cur;
            Node goat = cur.right;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            //cur.value = goat.value;

            if (goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }

    public static void main(String[] args) {
        //创建一个搜索树
        BinarySearchTree bs = new BinarySearchTree();
        //随机插入一些数据
        bs.insert(3);
        bs.insert(6);
        bs.insert(7);
        bs.insert(8);
        bs.insert(9);
        bs.insert(10);
        bs.insert(11);
        bs.inOrder(root);
        System.out.println(bs.search(4));
        boolean t = bs.remove(9);
        System.out.println(t);
        bs.inOrder(root);
    }


}
