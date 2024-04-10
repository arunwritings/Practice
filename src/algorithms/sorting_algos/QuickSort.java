package algorithms.sorting_algos;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    /**
     partition() is like a team leader who divides the work among team members based on a chosen number (pivot).
     The goal is to place all smaller numbers to the left and larger numbers to the right of this chosen number.
     **/
    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {   //Time complexity : Best and average case = O(log n) , worst case= O(n^2)
            while (arr.get(i) <= pivot && i<= high-1) {
                i++;
            }
            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    /**
     This method coordinates the process of dividing and conquering.
     It repeatedly divides the array into smaller parts until each part is sorted.
     **/
    public static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    /**
     This method is the entry point. It starts the sorting process.
     **/
    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> array;
        array = Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3, 8);
        int n = array.size();
        System.out.println("Before Using Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
        List<Integer> arrays = quickSort(array);
        System.out.println("After Quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arrays.get(i) + " ");
        }
        System.out.println();
    }
}
