package test_9_19;

import java.util.*;
public class Main{
    //只用前序遍历实现构建二叉树，并中序遍历输出
    public static class Node{
        char val;
        Node left;
        Node right;

        public Node(char val){
            this.val = val;
        }
    }
    public static class BTRV{
        private Node root;
        private int used;

        public BTRV(Node root,int used){
            this.root = root;
            this.used = used;
        }

        //中序遍历
        public static void inorderTraversal(Node root){
            if(root != null){
                inorderTraversal(root.left);
                System.out.print(root.val+" ");
                inorderTraversal(root.right);
            }
        }
        //构建二叉树
        public static BTRV builderTree(char[] preorder){
            if(preorder.length == 0){
                return new BTRV(null,0);
            }
            char rootValues = preorder[0];
            if(rootValues == '#'){
                return new BTRV(null,1);
            }
            Node root = new Node(rootValues);
            BTRV leftReturn = builderTree(Arrays.copyOfRange(preorder,1,preorder.length));
            BTRV rightReturn = builderTree(Arrays.copyOfRange(preorder,1+leftReturn.used,preorder.length));
            root.left = leftReturn.root;
            root.right = rightReturn.root;
            BTRV bv = new BTRV(root,1+leftReturn.used+rightReturn.used);
            return bv;
        }

        //二叉树的层序遍历（广度优先遍历） 利用队列实现
        public static void levelOrder(Node root){
            if(root != null){
                return;
            }
            Queue<Node> que = new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()){
                Node front = que.poll();
                System.out.println(front.val);
                if(front.left != null){
                    que.offer(front.left);
                }
                if(front.right != null){
                    que.offer(front.right);
                }
            }
        }



        //判断一棵二叉树是否为完全二叉树（层序遍历的变形）
        public static boolean isCompleteBinaryTree(Node root){
            if(root == null){
                return true;
            }
            String s = "";
            Queue<Node> que = new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()){
                Node front = que.poll();
                s += String.valueOf(front.val);
                if(front.left != null){
                    que.offer(front.left);
                }else{
                    s += "#";
                }
                if(front.right != null){
                    que.offer(front.right);
                }else{
                    s += "#";
                }
            }

            String[] temp = s.split("#");
            for (int i = 1; i < temp.length; i++) {
                if(temp[i] != ""){
                    return false;
                }
            }
            return true;
        }


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            char[] array = s.toCharArray();
            BTRV bv = builderTree(array);
            inorderTraversal(bv.root);
        }

    }
}