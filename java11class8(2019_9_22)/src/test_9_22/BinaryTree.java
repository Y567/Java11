package test_9_22;

import java.util.Stack;

/**
 * 非递归实现二叉树的前中后序遍历
 *
 */
public class BinaryTree {
    public static class Node{
        char val;
        Node left;
        Node right;

        public Node(char val){
            this.val = val;
        }
    }

    //前序遍历
    public static void preorder(Node root){
        Node cur = root;
        if(cur == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            //这里出栈就代表这左子树或者右子树（top结点没有右子树的时候）为空了
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //中序遍历
    public static void inorder(Node root){
        Node cur = root;
        if(cur == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }
    //后序遍历
    public static void postorder(Node root){
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        Node last = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if(cur.right == null || cur.right == last){
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else{
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }


}
