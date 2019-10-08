package test_10_8;



/**
 * 二叉排序树（二叉树形式的搜索树）
 * key-value模型
 */
public class Contact {
    public static class Node{
        String name;
        String value;
        Node left;
        Node right;

        public Node(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
    private static Node root;

    //更新
    public boolean upDate(String name,String value){
        Node cur = root;
        while(cur != null){
            int r = name.compareTo(cur.name);
            if(r == 0){
                cur.value = value;
                return true;
            }else if(r < 0){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return false;
    }
    //查找
    public String search(String name){
        Node cur = root;
        while(cur != null){
            int r = name.compareTo(cur.name);
            if(r == 0){
                return cur.value;
            }else if(r > 0){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }


}
