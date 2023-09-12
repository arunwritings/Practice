package data_structures;

public class SinglyLinkedList {

    //Represent a node of the linked list
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //Initialize the head and tail of the linked list
        Node head, tail = null;
    //addNode() will add a new node to the list
        public void addNode(int data){
            Node newNode = new Node(data);   //Create a new node
            //newNode will become new tail of the list
            if (head == null){      //Checks if the list is empty
                //If list is empty, both head and tail will point to new node
                head = newNode;
            }else {
                //newNode will be added after tail such that tail's next will point to newNode
                tail.next = newNode;
            }
            tail = newNode;
        }
    //display() will display all the nodes present in the list
        public void display(){
            //Node current will point to head
            Node current = head;
            if (head == null){
                System.out.println("List is empty....");
                return;
            }
            System.out.println("Nodes of Linked List....");
            while (current!=null){
                //print the data present in current node until it reaches null
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
            //Add nodes to the list
            singlyLinkedList.addNode(12);
            singlyLinkedList.addNode(15);
            singlyLinkedList.addNode(20);
            singlyLinkedList.addNode(25);
            //Displays the nodes present in the list
            singlyLinkedList.display();
        }

    }


