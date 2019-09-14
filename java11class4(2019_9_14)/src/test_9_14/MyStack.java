package test_9_14;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> que = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        que.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i = 0;i < que.size()-2;i++){
            que.add(que.remove());
        }
        return que.remove();
    }

    /** Get the top element. */
    public int top() {
        for(int i = 0;i < que.size()-2;i++){
            que.add(que.remove());
        }
        int result = que.remove();
        que.add(result);
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(que.size() <= 0){
            return true;
        }else{
            return false;
        }
    }
}
