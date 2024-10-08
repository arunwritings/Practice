package data_structures.linkedlists.easy;

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
    Node reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
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
        head=list.reverse();
        System.out.println();
        System.out.println("Reverse Linked List: ");
        list.printList(head);
    }
}
