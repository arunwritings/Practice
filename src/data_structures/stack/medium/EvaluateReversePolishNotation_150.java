package data_structures.stack.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","3","-"};
        EvaluateReversePolishNotation_150 evaluateReversePolishNotation150 = new EvaluateReversePolishNotation_150();
        System.out.println(evaluateReversePolishNotation150.evalRPN(tokens));
    }
}
