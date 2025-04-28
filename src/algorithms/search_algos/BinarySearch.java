package algorithms.search_algos;

public class BinarySearch {

    public static void binarySearch(int[] array, int start, int last, int key) {
        int middle = start + (last-start)/2;
        while (start<=last) {    //Since the loop iterating cut down to half, Time complexity = O(log n)
            if (array[middle] < key) {
                start = middle+1;
            } else if (array[middle] == key) {
                System.out.println("The key found at index "+middle);
                break;
            }else {
                last = middle-1;
            }
            middle = start + (last-start)/2;
        }
        if (start>last) {
            System.out.println("The key didn't found.");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        binarySearch(arr,0,9,2);

    }
}
