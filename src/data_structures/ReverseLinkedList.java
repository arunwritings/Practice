package data_structures;

public class ReverseLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    Node reverse(Node node){
        Node previous = null;
        Node current = node;
        Node next = null;
        while (current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        node = previous;
        return node;
    }
    void printList(Node node){
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Given Linked List: ");
        list.printList(head);
        head=list.reverse(head);
        System.out.println();
        System.out.println("Reverse Linked List: ");
        list.printList(head);
    }
}
