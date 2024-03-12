package algorithms.sorting_algos;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {  //Time Complexity = O(n^2) , Space Complexity = O(1)
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,4,2,3,8,5,7,9,6};
        insertionSort(array);
        System.out.println("After Insertion sort");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
