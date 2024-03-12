package algorithms.sorting_algos;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i=0;i<length-1;i++) {  //Time Complexity = O(n^2), Space Complexity = O(1)
            int index = i;
            for (int j=i+1;j<length;j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{10,4,2,6,7,3,5,8,9};
        selectionSort(array);
        System.out.println("After Selection sort");
        for (int i : array) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}
