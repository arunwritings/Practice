package data_structures.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_155 {

    private final Deque<Integer> stack = new ArrayDeque<>();

    private final Deque<Integer> minValuesStack = new ArrayDeque<>();

    public MinStack_155() {
        minValuesStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }

    public void pop() {
        stack.pop();
        minValuesStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValuesStack.peek();
    }

    public static void main(String[] args) {

    }
}
