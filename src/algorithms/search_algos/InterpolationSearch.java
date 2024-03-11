package algorithms.search_algos;

public class InterpolationSearch {

    private static void interpolationSearch(int[] array, int key) {
        int start = 0;
        int end = array.length-1;
        //Time complexity = O(log(log n)) this is best searching algo.
        //Worst case Time complexity = O(n) when element is not present in array
        while (key >= array[start] && key <= array[end] && end>=start) {
            int position = end + (key - array[end])/(array[end] - array[start]) * (end - start);
            if (start == end) {
                if (array[start] == key) {
                    System.out.println("The key found at index "+start);
                    break;
                }else System.out.println("The key didn't found.");
            }
            if (array[position] == key) {
                System.out.println("The key found at index "+position);
                break;
            }
            if (array[position] < key) {
                start = position+1;
            } else {
                end = position-1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,7,9,15,19,23};
        int key = 7;
        interpolationSearch(arr, key);
    }
}
