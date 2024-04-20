package data_structures.queues;

public class CircularQueueUsingArray {
    private final int[] array;
    private int start;
    private int end;
    private int currentSize;
    private final int maxSize;

    public CircularQueueUsingArray(int maxSize){
        this.maxSize=maxSize;
        array = new int[maxSize];
        start = -1;
        end = -1;
        currentSize = 0;
    }

    public void push(int newElement){
        if (currentSize == maxSize){
            System.out.println("The queue is full");
            System.exit(1);
        }
        if (end == -1){
            start = 0;
            end = 0;
        }else {
            end = (end +1)%maxSize;
        }
        array[end] = newElement;
        System.out.println("The element pushed is "+newElement);
        currentSize++;
    }

    public int pop(){
        if (start == -1){
            System.out.println("The queue is empty");
            System.exit(1);
        }
        int poppedElement = array[start];
        if (currentSize == 1){
            start = -1;
            end = -1;
        }else {
            start = (start+1)%maxSize;
        }
        currentSize--;
        return poppedElement;
    }

    public int firstElement(){
        if (start == -1){
            System.out.println("The queue is empty");
            System.exit(1);
        }
        return array[start];
    }

    public int size(){
        if (start == -1){
            System.out.println("The queue is empty");
            System.exit(1);
        }
        return currentSize;
    }

    public static void main(String[] args) {
        CircularQueueUsingArray queueUsingArray = new CircularQueueUsingArray(4);
        queueUsingArray.push(1);
        queueUsingArray.push(2);
        queueUsingArray.push(3);
        queueUsingArray.push(4);
        System.out.println("The peek of the queue before deleting "+queueUsingArray.firstElement());
        System.out.println("The size of the queue before deleting "+queueUsingArray.size());
        System.out.println("The first element to be deleted "+queueUsingArray.pop());
        System.out.println("The peek of the queue after deleting "+queueUsingArray.firstElement());
        System.out.println("The size of the queue after deleting "+queueUsingArray.size());
    }
}
