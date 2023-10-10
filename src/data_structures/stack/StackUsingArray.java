package data_structures.stack;

public class StackUsingArray {

    int size = 5;
    int[] stackArray = new int[size];
    int top=-1;

    void push(int data){
        top++;
        stackArray[top] = data;
    }

    int pop(){
        int temp = stackArray[top];
        top--;
        return temp;
    }

    int peek(){
        return stackArray[top];
    }

    int sizeOfStack(){
        return top+1;
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(10);
        stackUsingArray.push(20);
        stackUsingArray.push(30);
        stackUsingArray.push(40);
        stackUsingArray.push(50);
        System.out.println("The top element of stack before deleting is "+stackUsingArray.peek());
        System.out.println("The size of the stack before deleting is "+stackUsingArray.sizeOfStack());
        System.out.println("The deleting element is "+stackUsingArray.pop());
        System.out.println("The size of the stack after deleting is "+stackUsingArray.sizeOfStack());
        System.out.println("The top element of stack after deleting is "+stackUsingArray.peek());
    }
}
