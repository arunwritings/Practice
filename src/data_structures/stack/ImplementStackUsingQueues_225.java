package data_structures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; ++i) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        ImplementStackUsingQueues_225 obj = new ImplementStackUsingQueues_225();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println("The popping element is "+ param_2);
        System.out.println("The top element is "+param_3);
        System.out.println("Is the Stack empty "+param_4);
    }
}
