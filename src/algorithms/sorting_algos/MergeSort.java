package algorithms.sorting_algos;

public class MergeSort {

    public static void mergeSort(int[] array) {  // Dividing array into two subArrays until it becomes single element
        if (array == null || array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
        //System.arraycopy method copies elements: From array into leftArray (from index 0 to mid).
        System.arraycopy(array, 0, leftArray, 0, mid);

        if (array.length - mid >= 0)
            //The System.arraycopy method copies elements: From array into rightArray (from index mid to the end).
            System.arraycopy(array, mid, rightArray,
                    0, array.length - mid);

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) { // sorting the array in reverse method
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) { // Time complexity = O(n log n)
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        var array = new int[]{3, 9, 10, 1, 8, 7, 5, 2};
        mergeSort(array);
        for (int element: array) {
            System.out.print(element + " ");
        }
    }
}
