package test_9_14;

import java.util.Stack;

public class DemoStack {
    //栈的简单的使用
    public static void main(String[] args) {
        Stack<String> stringStack =  new Stack<>();
        stringStack.push("阿崇");
        stringStack.push("打豆豆");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.empty());
        System.out.println(stringStack.peek());
    }
}
