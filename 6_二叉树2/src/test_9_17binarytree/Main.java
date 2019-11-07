package test_9_17binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString()  {
        return String.format("%c ",this.val);
    }
}
public class Main {

    //按照前序遍历数组和中序遍历数组构建二叉树
    public static Node buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int rootValues = preorder[0];
        Node root = new Node(rootValues);
        int leftCount = 0;
        for(leftCount = 0;leftCount < inorder.length;leftCount++){
            if(inorder[leftCount] == rootValues){
                break;
            }
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,leftCount+1);
        int[] leftInorder = Arrays.copyOfRange(inorder,0,leftCount);
        root.left = buildTree(leftPreorder,leftInorder);
        int[] rightPreorder = Arrays.copyOfRange(preorder,leftCount+1,preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        root.right = buildTree1(rightPreorder,rightInorder);
        return root;
    }

    //根据中序遍历和后序遍历创建二叉树
    public static Node buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        int rootValues = postorder[postorder.length-1];
        Node root = new Node(rootValues);
        int leftCount = 0;
        for(leftCount = 0;leftCount < inorder.length;leftCount++){
            if(inorder[leftCount] == rootValues){
                break;
            }
        }
        //统计出了左子树的节点数后求出左子树中序遍历的数组
        int[] leftInorder = Arrays.copyOfRange(inorder,0,leftCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder,0,leftCount);
        root.left = buildTree(leftInorder,leftPostorder);
        //建右子树
        int[] rightInorder = Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder,leftCount,inorder.length-1);
        root.right = buildTree(rightInorder,rightPostorder);
        return root;
    }

    /*
    题目：
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean search(Node root,Node t){
        if(root == null){
            return false;
        }
        if(root == t){
            return true;
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(p == root || q == root){
            return root;
        }
        boolean pInleft = search(root.left,p);
        boolean qInleft = search(root.left,q);
        if(pInleft && qInleft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pInleft && !qInleft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }










    private static List<Integer> list = new ArrayList<>();
    //后序遍历
    public static List<Integer> postOrderTraversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    //汇总思想
    public static List<Integer> postOrderTraversal2(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> left = postOrderTraversal2(root.left);
        List<Integer> right = postOrderTraversal2(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }

    //相等
    public static boolean isSameTree(Node s,Node t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val == t.val && isSameTree(s.left,t.left) && isSameTree(s.right,t.right)){
            return true;
        }
        return false;
    }
    //t是否是s的子树(s,t一定不为空树)
    public static boolean isSubTree(Node s,Node t){
        if(isSameTree(s.left,t) || isSameTree(s.right,t) || isSameTree(s,t)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("gaonangniang");
    }
 }
