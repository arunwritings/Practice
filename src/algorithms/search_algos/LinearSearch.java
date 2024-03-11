package algorithms.search_algos;

public class LinearSearch {

    public static void linearSearch(int[] array, int key) {
        for (int i=0;i<array.length;i++) {
            if (array[i] == key) System.out.println("The key found at index "+i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,3,5,7,6,8,9};
        linearSearch(arr,6);
    }
}
