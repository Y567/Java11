package test_9_14;

import java.util.List;

public class BinaryTree {
    private static class Node{
        private char val;
        private Node left;
        private  Node right;

        //这里构造方法只是内部使用，所以可以为private
        private Node(char val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("%c ",this.val);
        }
    }

    public static Node builderTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;
        return a;

    }

    //前序遍历
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //根，左右
        System.out.print(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public static void midOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //左根右
        midOrderTraversal(root.left);
        System.out.print(root);
        midOrderTraversal(root.right);
    }

    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //左右根
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root);
    }

    //遍历求结点个数
    private static int count = 0;
    public static void getSize(Node root){
        if(root == null){
            return;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
    }

    //汇总的思想求节点数（根加左加右）
    public static int getSize2(Node root){
        if(root == null){
            return 0;
        }

        //求出左子树和右子树的结点数
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left+right+1;
    }

//    //汇总的思想：前序遍历
//    public static List<Integer>


    //求叶子结点的个数(遍历思想:一个个结点)
    private static int leafSize = 0;
    private static void getLeafSize(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    //汇总思想(一颗颗子树)求叶子节点个数
    private static int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left+right;
    }



    //求二叉树的高度(汇总的思想)
    private static int getBinaryTreeOfHigh(Node root){
        if(root == null){
            return 0;
        }
        int left = getBinaryTreeOfHigh(root.left);
        int right = getBinaryTreeOfHigh(root.right);
        return Math.max(left,right)+1;
    }
    public static void main(String[] args) {
        Node root = builderTree();
        System.out.println("前");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("中");
        midOrderTraversal(root);
        System.out.println();
        System.out.println("后");
        postOrderTraversal(root);
        System.out.println("测试一下二叉树的高度为"+getBinaryTreeOfHigh(root));
    }
}
