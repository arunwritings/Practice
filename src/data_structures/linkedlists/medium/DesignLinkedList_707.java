package data_structures.linkedlists.medium;

public class DesignLinkedList_707 {

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head, tail;
    private int size;
    public DesignLinkedList_707() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i=0;i<index;i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }
        Node temp = head;
        for (int i=0;i<index-1;i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
            size--;
            return;
        }
        Node temp = head;
        for (int i=0;i<index-1;i++) {
            temp = temp.next;
        }
        Node node = temp.next;
        temp.next = node.next;
        if (index == size-1) {
            tail = temp;
        }
        size--;
    }
    public static void main(String[] args) {
        DesignLinkedList_707 designLinkedList707 = new DesignLinkedList_707();
        int index = 1;
        int value = designLinkedList707.get(index);
        System.out.println(value);
        designLinkedList707.addAtHead(value);
        designLinkedList707.addAtTail(value);
        designLinkedList707.addAtIndex(index, value);
        designLinkedList707.deleteAtIndex(index);
    }
}
