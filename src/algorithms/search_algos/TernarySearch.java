package algorithms.search_algos;

public class TernarySearch {

    public static int ternarySearch(int[] arr, int start, int end, int key) {
        if (end >= 1) {   //Time Complexity = O(log3 n)
            int middle1 = start + (end-start)/3;
            int middle2 = end - (end-start)/3;
            if (key == arr[middle1]) {
                return middle1;
            }
            else if (key == middle2) {
                return middle2;
            }
            if (key < arr[middle1]) {
                return ternarySearch(arr,1,middle1-1, key);
            } else if (key > arr[middle2]) {
                return ternarySearch(arr, middle2+1,end-1, key);
            }else {
                return ternarySearch(arr,middle1+1, middle2-1, key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int start = 0;
        int end = 9;
        int key = 7;
        int index = ternarySearch(array,start,end,key);
        System.out.println((index<0)? "The key didn't found" : "The key is found at index "+index);
    }
}
