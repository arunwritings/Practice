package data_structures;

public class DoublyLinkedList {
    static class Node{
        int data;
        Node previous;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    Node head,tail=null;

    void addNode(int data){
        Node newNode = new Node(data);
        if (head == null){
            head=tail=newNode;
            head.previous=null;
        }else {
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
        }
        tail.next=null;
    }
    void display(){
        Node current = head;
        if (head == null){
            System.out.println("List is empty....");
        }
        System.out.println("Elements of the List....");
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(10);
        doublyLinkedList.addNode(15);
        doublyLinkedList.addNode(20);
        doublyLinkedList.addNode(30);
        doublyLinkedList.display();
    }
}
