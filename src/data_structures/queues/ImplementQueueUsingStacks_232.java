package data_structures.queues;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public ImplementQueueUsingStacks_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks_232 implementQueueUsingStacks232 = new ImplementQueueUsingStacks_232();
        implementQueueUsingStacks232.push(2);
        implementQueueUsingStacks232.peek();
        implementQueueUsingStacks232.pop();
        implementQueueUsingStacks232.empty();
    }
}
