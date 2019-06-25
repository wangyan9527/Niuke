package practice.queueAndStack;

import java.util.Stack;

/**
 * 用两个栈来实现队列，完成队列的push和pop操作。
 */
public class StackToList {

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}

class CustomQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public Integer pop() {
        // 全部取出,并按顺序插入到stack2中
        while(stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        Integer value = stack1.pop();
        // 取出并存到stack2中
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }
}