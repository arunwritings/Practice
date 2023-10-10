package data_structures.linkedlists;

public class CircularLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    Node head,tail=null;
    void addNode(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            newNode.next=head;
        }else {
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
    }
    void display(){
        Node current= head;
        if (head==null){
            System.out.println("List is empty....");
        }else {
            System.out.println("Elements of the list ...");
            do {
                System.out.print(" "+current.data);
                current=current.next;
            }while (current!=head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addNode(15);
        circularLinkedList.addNode(51);
        circularLinkedList.addNode(35);
        circularLinkedList.display();
    }
    }

