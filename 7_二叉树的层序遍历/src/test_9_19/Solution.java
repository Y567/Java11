package test_9_19;

import java.util.*;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //通过这个类将结点与等级封装在一起，借助等级创建内部集合来添加元素；
    class NL{
        TreeNode node;
        int level;
        public NL(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Queue<NL> que = new LinkedList<>();
        NL front = new NL(root,0);
        que.offer(front);
        while(!que.isEmpty()){
            front = que.poll();
            //这里通过比较可以很巧妙的创建内部集合，level表示了结点该属于那一行，行数对应
            //这外层集合的元素个数
            if(list.size() == front.level){
                list.add(new LinkedList());
            }
            List<Integer> in = list.get(front.level);
            in.add(front.node.val);
            if(front.node.left != null){
                NL temp = new NL(front.node.left,front.level+1);
                que.offer(temp);
            }
            if(front.node.right != null){
                NL temp2 = new NL(front.node.right,front.level+1);
                que.offer(temp2);
            }
        }
        return list;
    }
}
