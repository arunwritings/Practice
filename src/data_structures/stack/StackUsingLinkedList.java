package data_structures.stack;

public class StackUsingLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node top;
    int size;

    StackUsingLinkedList(){
        this.top = null;
        this.size = 0;
    }
    boolean isEmpty(){
        return top == null;
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
        System.out.println("Element pushed");
        size++;
    }

    int pop(){
        if (isEmpty())return -1;
        int poppingElement = top.data;
        top = top.next;
        size--;
        return poppingElement;
    }

    public int stackSize() {
        return size;
    }

    int peek(){
        return top.data;
    }

    void display(){
        Node current = top;
        while (current!=null){
            System.out.println(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList list = new StackUsingLinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        System.out.println("The size of the stack before deleting is "+list.stackSize());
        System.out.println("The elements in stack are ");
        list.display();
        System.out.println("The element we are deleting is "+list.pop());
        System.out.println("The top element of stack after deleting is "+list.peek());
        System.out.println("The size of the stack after deleting is "+list.stackSize());

    }
}
