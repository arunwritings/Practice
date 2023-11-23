package data_structures.queues;

public class QueueUsingLinkedList {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node start,end = null;
    int size = 0;

    boolean isEmpty(){
        return start == null;
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }
        else return start.data;
    }

    public void enQueue(int newElement){
        Node newNode = new Node(newElement);
        if (start == null){
            start = newNode;
        }else {
            end.next = newNode;
        }
        end = newNode;
        System.out.println(newElement+" is added to Queue");
        size++;
    }

    public void deQueue(){
        if (start == null){
            System.out.println("The Queue is empty");
        }else {
            System.out.println(start.data+" is removed from Queue");
            start = start.next;
            size--;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.enQueue(10);
        queueUsingLinkedList.enQueue(20);
        queueUsingLinkedList.enQueue(30);
        queueUsingLinkedList.enQueue(40);
        System.out.println("The size of the Queue before removing "+queueUsingLinkedList.size);
        System.out.println("The front element of the Queue before removing "+queueUsingLinkedList.peek());
        queueUsingLinkedList.deQueue();
        System.out.println("The size of the Queue after removing "+queueUsingLinkedList.size);
        System.out.println("The front element of the Queue after removing "+queueUsingLinkedList.peek());

    }
}
