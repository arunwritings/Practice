package algorithms.sorting_algos;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i=0;i<length-1;i++) {  //Time Complexity = O(n^2), Space Complexity = O(1)
            for (int j = 0;j<length-i-1;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,5,7,4,6};
        bubbleSort(array);
        System.out.println("Array after bubble sort:");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
